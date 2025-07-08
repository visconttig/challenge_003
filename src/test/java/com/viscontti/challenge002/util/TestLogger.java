package com.viscontti.challenge002.util;

import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class TestLogger {
    public static void assertWithLog(String label,
                                    Object expected,
                                    Object actual){
        System.out.printf("%n- Test: %s%n", label);
        System.out.printf("\tExpected: %s%n", expected);
        System.out.printf("\tActual: %s%n", actual);

        if(Objects.equals(expected, actual)){
            System.out.printf("\t--- PASS ---%n%n");
        } else {
            System.out.printf("\t--- FAIL ---%n%n");
        }

        Assertions.assertEquals(expected, actual);
    }
}
