package com.viscontti.challenge002.util;


public class ConsolePrinter {

    public static String printSeparator(){
        String separator = "##############################################";
        System.out.print(separator);
        return separator;
    }

    public static void printHeader(String header){
        System.out.printf("%n%n##########\t%s\t##########%n%n", header);
    }

    public static void printLine(String line){
        System.out.printf("%s", line);
    }

    public static void printLineBreak(String line){
        System.out.printf("%s%n", line);
    }

    public static void printFormatted(String format, Object... args){
        System.out.printf(format, args);
    }

    public static void printFormatted(String format){
        System.out.printf(format);
    }


    public static void printError(Exception e) {
        printFormatted("An error occurred:\t%s.%n", e);
    }
}
