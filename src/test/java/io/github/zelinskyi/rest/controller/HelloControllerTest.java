package io.github.zelinskyi.rest.controller;


import io.github.zelinskyi.services.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {
    
    @Mock
    private HelloService helloService;
    
    @Test
    public void testHelloStatus() {
        
        when(helloService.hello()).thenReturn("hello");
        HelloController controller = new HelloController(helloService);
        assertThat(controller.helloStatus(), equalTo(HttpStatus.OK));
    }
}