package com.viscontti.challenge002;

import com.viscontti.challenge002.exception.MenuOptionOutOfBoundsException;
import com.viscontti.challenge002.main.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Challenge002ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMenuValidatorGivenOutOfBoundsShouldThrow(){
		var input = 99;
		assertThrows(MenuOptionOutOfBoundsException.class, () -> {
			Main.validateMenuOption(1, 6, input);
		} );
	}
}
