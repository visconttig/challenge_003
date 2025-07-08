package com.viscontti.challenge002;
import com.viscontti.challenge002.exception.MenuOptionOutOfBoundsException;
import com.viscontti.challenge002.util.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {
    @BeforeEach
    void logTestInfo(TestInfo testInfo){
        System.out.printf("### Running test:\t%s%n",
                          testInfo.getDisplayName());
    }


    @DisplayName("Menu validator should throw an error for input out of bounds")
    @Test
    void testMenuValidatorGivenOutOfBoundsShouldThrow(){
        Menu menu = new Menu();
        var input = 99;

        assertThrows(MenuOptionOutOfBoundsException.class, () -> {
            menu.validateMenuOption(input);
        } );
    }

}
