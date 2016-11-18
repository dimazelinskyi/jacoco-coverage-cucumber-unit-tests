package io.github.zelinskyi;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class HelloWorldTest {
	
	
	@Test
	public void sayHello() throws Exception {
		
		HelloWorld helloWorld = new HelloWorld();
		assertThat(helloWorld.sayHello(), equalTo("Hello!"));
	}
}