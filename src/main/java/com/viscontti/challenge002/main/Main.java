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
import com.viscontti.challenge002.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Profile("cli")
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

    @Value("${cli.enabled:true}")
    private boolean cliEnabled;

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

        if(!cliEnabled){
            return;
        }

        menu.addOption(new MenuOption(1,
                                      "Search book by title.",
                                      this::searchBookByTitle));
        menu.addOption(new MenuOption(2,
                                      "List registered books.",
                                      this::listAllBooks));
        menu.addOption(new MenuOption(3,
                                      "List registered authors.",
                                      this::listAllAuthors));
        menu.addOption(new MenuOption(4,
                                      "List alive authors in a given year.",
                                      this::listAliveAuthors));
        menu.addOption(new MenuOption(5,
                                      "List books by language.",
                                      () -> this.listBooksByLanguage()));
        menu.addOption(new MenuOption(6,
                                      "EXIT.",
                                      null));
        askMenuOption();

    }

    public void askMenuOption(){
        try {
            do {
                menu.displayMenu();
                ConsolePrinter.printLine("Select an option:\t");
                selectedOption = InputHelper.getInputNumber(sc);
                if(menu.validateMenuOption(selectedOption)){
                    executeSelectedOption(selectedOption);
                }
            } while (selectedOption != 6);
                ConsolePrinter.printLineBreak("Exiting app...");
                System.exit(0);
        } catch (MenuOptionOutOfBoundsException e){
            ConsolePrinter.printFormatted("**Error** \t%s%n", e);
            ConsolePrinter.printFormatted("Enter a number between 1 and %s.%n%n",
                                          menu.getSize());
            askMenuOption();
        } catch (NumberFormatException e) {
            ConsolePrinter.printFormatted("**Error** Enter a valid number:\t%s.%n%n", e);
            askMenuOption();
        } catch (Exception e) {
            ConsolePrinter.printFormatted("An error occurred:\t%s.%n%n", e);
        } finally {
            sc.close();
        }
    }

    public void executeSelectedOption(int selectedOption){
       menu.getOptionByNumber(selectedOption).execute();
    }

    public void searchBookByTitle(){
        try {
            ConsolePrinter.printLine("Enter a title to search for:\t");
            String title = InputHelper.getInputString(sc);
            ConsolePrinter.printFormatted("Searching by title: %s...%n%n", title);
            String result = booksHttpService.searchBooksByTitle(title);
            GutendexDTO guten = mapper.readValue(result, GutendexDTO.class);
            List<BookDTO> books = guten.getResults();
            if(books.isEmpty()){
                ConsolePrinter.printFormatted("No results found for \"%s\".%nTry another search.%n%n",
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
                    ConsolePrinter.printFormatted("Ingnoring book [Already in the database]:\n");
                    booksService.printBookInfo(book);
                } else {
                    ConsolePrinter.printLine("Saving book:\t");
                    booksService.printBookInfo(book);
                    booksService.saveBook(book);
                }
            }

            ConsolePrinter.printHeader("Stored Books");
            booksService.printAllBooks();
            ConsolePrinter.printFormatted("%n%n");
        } catch (Exception e) {
            ConsolePrinter.printFormatted("An error occurred:\t%s%n%n", e);
        }
    }

    public void listAliveAuthors(){
        ConsolePrinter.printLine("Enter a year: \t");
        int year = InputHelper.getInputNumber(sc);
        ConsolePrinter.printFormatted("%n%n");
        List<Author> authors = authorsService.findByAliveInYear(year);
        if(!authors.isEmpty()){
            ConsolePrinter.printFormatted("Alive authors in that year:%n\\t");
            authorsService.printAllAuthors(authors);
        } else {
            ConsolePrinter.printFormatted("No authors alive found in that year:\\t%d.%n%n", year);
        }
    }

    public void listAllBooks(){
        ConsolePrinter.printHeader("Books:");
        booksService.printAllBooks();
    }

    public void listAllAuthors(){
        ConsolePrinter.printHeader("Authors");
        var authors = authorsService.getAllAuthors()
                        .stream()
                                .distinct()
                                        .toList();
        authorsService.printAllAuthors(authors);
    }

    public void listBooksByLanguage(){
        String searchedLanguage = null;

        while (true){
            try {
                ConsolePrinter.printHeader("*** Language Codes ***");
                ConsolePrinter.printFormatted("""
+------------+--------------------+
| Language   | Code               |
+------------+--------------------+
| English    | en                 |
| Spanish    | es                 |
| French     | fr                 |
| German     | de                 |
| Italian    | it                 |
| Portuguese | pt                 |
| Russian    | ru                 |
| Chinese    | zh                 |
| Japanese   | ja                 |
| Arabic     | ar                 |
+------------+--------------------+
""");
                ConsolePrinter.printLine("Enter a language code (ex: 'fr', 'en', etc):\t");
                if(sc.hasNextLine()){
                    searchedLanguage = InputHelper.getInputString(sc);
                    if((searchedLanguage == null) || (searchedLanguage.isBlank())){
                        ConsolePrinter.printFormatted("Invalid input. Please try again.%n%n");
                        continue;
                    }
                }

                ConsolePrinter.printFormatted("Searching by language...%n%n");
                List<Book> books = booksService.getBooksByLanguage(searchedLanguage);
                if(!(books.isEmpty())){
                    ConsolePrinter.printHeader(String.format("'%s' books ", searchedLanguage));
                    booksService.printAllBooks(books);
                } else {
                    ConsolePrinter.printFormatted("No books found for '%s' language code.%n%n",
                                                  searchedLanguage);
                }

                break;

            } catch (NoSuchElementException e){
                ConsolePrinter.printError(e);
            }
        }

    }

}


















