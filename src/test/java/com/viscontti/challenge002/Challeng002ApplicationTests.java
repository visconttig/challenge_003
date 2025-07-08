package com.viscontti.challenge002;

import com.viscontti.challenge002.config.StartupRunner;
import com.viscontti.challenge002.main.Main;
import com.viscontti.challenge002.util.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {Menu.class})
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Main.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = StartupRunner.class)
})
class Challenge002ApplicationTests {

	@Test
	void contextLoads() {
	}

}
