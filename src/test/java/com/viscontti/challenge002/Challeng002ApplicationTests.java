package com.viscontti.challenge002;

import com.viscontti.challenge002.config.StartupRunner;
import com.viscontti.challenge002.main.Main;
import com.viscontti.challenge002.util.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {Menu.class})
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Main.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = StartupRunner.class)
})
class Challenge002ApplicationTests {
	@BeforeEach
	void logTestInfo(TestInfo testInfo){
		System.out.printf("### Running test:\t%s%n",
						  testInfo.getDisplayName());
	}


	@DisplayName("Context should load successfully")
	@Test
	void contextLoads() {
	}

}
