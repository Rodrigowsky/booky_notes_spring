package com.proprojects.bookynotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/hello")
	public String sayHello() {

		return "helloworld";
	}
}
