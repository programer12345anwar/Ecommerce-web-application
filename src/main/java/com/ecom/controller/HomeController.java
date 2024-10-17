package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//to handle the request
@Controller
public class HomeController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/products")
	public String products() {
		return "product";
	}

	@GetMapping("/product")
	public String product() {
		return "view_product";
	}
}
