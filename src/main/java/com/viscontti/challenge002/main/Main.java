package com.viscontti.challenge002.main;

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

    @Autowired
    public Main(BooksHttpService booksHttpService,
                Menu menu){
       this.booksHttpService = booksHttpService;
       this.menu = menu;
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
        try (Scanner sc = new Scanner(System.in)) {
            do {
                menu.displayMenu();
                System.out.print("Select an option:\t");
                selectedOption = sc.nextInt();
            } while (selectedOption != 6);
        } catch (InputMismatchException e) {
            System.out.printf("Enter a valid number:\t%s", e);
            askMenuOption();
        } catch (Exception e) {
            System.out.printf("An error occurred:\t%s", e);
        }
    }
}


















