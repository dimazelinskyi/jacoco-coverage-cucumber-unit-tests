package io.github.zelinskyi.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public HttpStatus helloStatus() {
		return HttpStatus.OK;
	}
}
