package com.viscontti.challenge002.util;

public class MenuOption {
    private final Integer number;
    private final String description;
    private final Runnable action;

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
