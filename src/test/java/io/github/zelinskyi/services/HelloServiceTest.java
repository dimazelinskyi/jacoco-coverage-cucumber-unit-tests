package io.github.zelinskyi.services;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloServiceTest {
	
	@Test
	public void testHello() {
		
		HelloService helloService = new HelloService();
		assertThat(helloService.hello(), is("hello"));
	}
}