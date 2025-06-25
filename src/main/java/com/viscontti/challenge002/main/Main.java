package com.viscontti.challenge002.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viscontti.challenge002.dto.BookDTO;
import com.viscontti.challenge002.dto.GutendexDTO;
import com.viscontti.challenge002.exception.MenuOptionOutOfBoundsException;
import com.viscontti.challenge002.model.Author;
import com.viscontti.challenge002.model.Book;
import com.viscontti.challenge002.service.AuthorsService;
import com.viscontti.challenge002.service.BooksHttpService;
import com.viscontti.challenge002.service.BooksService;
import com.viscontti.challenge002.util.BookMapper;
import com.viscontti.challenge002.util.Menu;
import com.viscontti.challenge002.util.MenuOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Main implements CommandLineRunner {
    private final BooksHttpService booksHttpService;
    private final Menu menu;
    int selectedOption = -1;
    Scanner sc;
    ObjectMapper mapper;
    BookMapper bookMapper;
    BooksService booksService;
    AuthorsService authorsService;

    @Autowired
    public Main(BooksHttpService booksHttpService,
                Menu menu,
                BookMapper bookMapper,
                BooksService booksService,
                AuthorsService authorsService){
       this.booksHttpService = booksHttpService;
       this.menu = menu;
       this.sc = new Scanner(System.in);
       this.mapper = new ObjectMapper();
       this.bookMapper = bookMapper;
       this.booksService = booksService;
       this.authorsService = authorsService;
    }


    @Override
    public void run(String... args) throws Exception {
        menu.addOption(new MenuOption(1,
                                      "Search book by title.",
                                      this::searchBookByTitle));
        menu.addOption(new MenuOption(2,
                                      "List registered books.",
                                      this::listAllBooks));
        menu.addOption(new MenuOption(3,
                                      "List registered authors.",
                                      null));
        menu.addOption(new MenuOption(4,
                                      "List alive authors in a given year.",
                                      this::listAliveAuthors));
        menu.addOption(new MenuOption(5,
                                      "List books by language.",
                                      null));
        menu.addOption(new MenuOption(6,
                                      "EXIT.",
                                      null));
        askMenuOption();

    }

    public void askMenuOption(){
        try {
            do {
                menu.displayMenu();
                System.out.print("Select an option:\t");
                selectedOption = inputNumber();
                if(menu.validateMenuOption(selectedOption)){
                    executeSelectedOption(selectedOption);
                }
            } while (selectedOption != 6);
                System.out.println("Exiting app...");
                System.exit(0);
        } catch (MenuOptionOutOfBoundsException e){
            System.out.printf("**Error** \t%s%n", e);
            System.out.printf("Enter a number between 1 and 6.%n%n");
            askMenuOption();
        } catch (NumberFormatException e) {
            System.out.printf("**Error** Enter a valid number:\t%s.%n%n", e);
            askMenuOption();
        } catch (Exception e) {
            System.out.printf("An error occurred:\t%s.%n%n", e);
        } finally {
            sc.close();
        }
    }


    public int inputNumber() throws NumberFormatException {
       return Integer.parseInt(sc.nextLine());
    }

    public String inputString() {
        return sc.nextLine();
    }

    public void executeSelectedOption(int selectedOption){
       menu.getOptionByNumber(selectedOption).execute();
    }

    public void searchBookByTitle(){
        try {
            System.out.println("Enter a title to search for: ");
            String title = inputString();
            System.out.printf("Searching by title: %s...%n%n", title);
            String result = booksHttpService.searchBooksByTitle(title);
            GutendexDTO guten = mapper.readValue(result, GutendexDTO.class);
            List<BookDTO> books = guten.getResults();
            if(books.isEmpty()){
                System.out.printf("No results found for \"%s\".%nTry another search.%n%n",
                                  title);
                return;
            }
            List<BookDTO> filteredBooksByTitle = books.stream()
                    .filter((bookDTO -> bookDTO.getTitle()
                            .toLowerCase()
                            .contains(title.toLowerCase())))
                    .toList();
            List<Book> savedBooks = booksService.getAllBooks();
            for(BookDTO bookDTO : filteredBooksByTitle ){
                Book book = bookMapper.toEntity(bookDTO);
                if(savedBooks.stream()
                        .anyMatch((book1 -> book1.getName()
                                .equalsIgnoreCase(book.getName())))){
                    System.out.print("Ingnoring book [Already in the database]:%n");
                    booksService.printBookInfo(book);
                } else {
                    System.out.print("Saving book: ");
                    booksService.printBookInfo(book);
                    booksService.saveBook(book);
                }
            }
            System.out.println("\n\n");
        } catch (Exception e) {
            System.out.printf("An error occurred:\t%s%n%n", e);
        }
    }

    public void listAliveAuthors(){
        System.out.println("Enter a year:\t");
        int year = inputNumber();
        System.out.printf("%n%n");
        List<Author> authors = authorsService.findByAliveInYear(year);
        if(!authors.isEmpty()){
            printMessage(String.format("Alive authors in that year:%n\t"));
            authorsService.printAllAuthors(authors);
        } else {
            printMessage(String.format("No authors alive found in that year:\t%d.%n%n",
                                       year));
        }
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public void listAllBooks(){
        booksService.printAllBooks();
    }

}


















