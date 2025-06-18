package com.viscontti.challenge002.exception;

public class MenuOptionOutOfBoundsException extends RuntimeException {
    public MenuOptionOutOfBoundsException(int userInput){
        super(String.format("Invalid Menu Option:\t%d.", userInput));
    }
}
