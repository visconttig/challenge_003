package com.viscontti.challenge002.util;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Menu {
    private List<MenuOption> options = new ArrayList<>();

    public void addOption(MenuOption menuOption){
        options.add(menuOption);
    }

    public void removeOption(int number){
        options.removeIf((opt) -> opt.getNumber() == number);
    }

    public void displayMenu(){
        String separator = "##############################################";
        System.out.println(separator);
        for(MenuOption option : options){
            System.out.printf("%d:\t%s%n", option.getNumber(), option.getDescription() );
        }
        System.out.println(separator);
    }

    public MenuOption getOptionByNumber(int number){
      return options.stream()
                .filter(opt -> opt.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

}