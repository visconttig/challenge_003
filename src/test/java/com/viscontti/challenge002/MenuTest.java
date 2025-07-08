package com.viscontti.challenge002;
import com.viscontti.challenge002.exception.MenuOptionOutOfBoundsException;
import com.viscontti.challenge002.util.Menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {

    @Test
    void testMenuValidatorGivenOutOfBoundsShouldThrow(){
        Menu menu = new Menu();
        var input = 99;

        assertThrows(MenuOptionOutOfBoundsException.class, () -> {
            menu.validateMenuOption(input);
        } );
    }

}
