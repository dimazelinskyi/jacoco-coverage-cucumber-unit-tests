package io.github.zelinskyi.rest.controller;


import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class HelloControllerTest {
	
	@Test
	public void testHelloStatus() {
		
		HelloController controller = new HelloController();
		assertThat(controller.helloStatus(), equalTo(HttpStatus.OK));
	}
}