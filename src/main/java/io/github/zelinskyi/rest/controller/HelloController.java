package io.github.zelinskyi.rest.controller;

import io.github.zelinskyi.services.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    private HelloService helloService;
    
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public HttpStatus helloStatus() {
        
        return helloService.hello() == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    }
}
