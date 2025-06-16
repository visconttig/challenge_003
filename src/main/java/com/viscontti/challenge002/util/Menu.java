package com.viscontti.challenge002.util;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuOption> options = new ArrayList<>();

    public void addOption(MenuOption menuOption){
        options.add(menuOption);
    }

    public void removeOption(int number){
        options.removeIf((opt) -> opt.getNumber() == number);
    }

    public void displayMenu(){
        for(MenuOption option : options){
            System.out.printf("%d:\t%s%n", option.getNumber(), option.getDescription() );
        }
    }

    public MenuOption getOptionByNumber(int number){
      return options.stream()
                .filter(opt -> opt.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

}

class MenuOption {
    private Integer number;
    private String description;
    private Runnable action;

    public MenuOption(Integer number,
                      String description,
                      Runnable action){
        this.number = number;
        this.description = description;
        this.action = action;
    }

    public int getNumber(){
        return number;
    }

    public String getDescription(){
        return description;
    }

    public Runnable getAction(){
        return action;
    }

    public void execute(){
        if(action != null){
            action.run();
        }
    }

}
