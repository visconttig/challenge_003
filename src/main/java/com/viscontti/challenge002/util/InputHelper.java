package com.viscontti.challenge002.util;

import java.util.Scanner;

public class InputHelper {

    public static int getInputNumber(Scanner sc) throws NumberFormatException {
        return Integer.parseInt(sc.nextLine());
    }

    public static String getInputString(Scanner sc){
        return sc.nextLine();
    }
}
