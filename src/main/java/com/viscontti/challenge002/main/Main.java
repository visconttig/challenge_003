package com.viscontti.challenge002.main;

import com.viscontti.challenge002.exception.MenuOptionOutOfBoundsException;
import com.viscontti.challenge002.service.BooksHttpService;
import com.viscontti.challenge002.util.Menu;
import com.viscontti.challenge002.util.MenuOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class Main implements CommandLineRunner {
    private final BooksHttpService booksHttpService;
    private final Menu menu;
    int selectedOption = -1;
    Scanner sc;

    @Autowired
    public Main(BooksHttpService booksHttpService,
                Menu menu){
       this.booksHttpService = booksHttpService;
       this.menu = menu;
       this.sc = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        menu.addOption(new MenuOption(1,
                                      "Search book by title.",
                                      null));
        menu.addOption(new MenuOption(2,
                                      "List registered books.",
                                      null));
        menu.addOption(new MenuOption(3,
                                      "List registered authors.",
                                      null));
        menu.addOption(new MenuOption(4,
                                      "List alive authors in a given year.",
                                      null));
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
                selectedOption = sc.nextInt();
                validateMenuOption(1, 6, selectedOption);
            } while (selectedOption != 6);
            System.out.println("Exiting app...");
            System.exit(0);
        } catch (MenuOptionOutOfBoundsException e){
            System.out.printf("Error:\t%s.%n", e);
            System.out.printf("Enter a number between 1 and 6.%n%n");
            askMenuOption();
        } catch (InputMismatchException e) {
            System.out.printf("Enter a valid number:\t%s", e);
            askMenuOption();
        } catch (Exception e) {
            System.out.printf("An error occurred:\t%s", e);
        }
    }


    public int inputNumber() {
        //
        return -1;
    }

    public void validateMenuOption(int min, int max, int userInput){
       if((userInput < min) || (userInput > max)){
           throw new MenuOptionOutOfBoundsException(userInput);
       }
    }
}


















