package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("")

	public String admin() {
		return "admin/index";
	}

	@GetMapping("/loadAddProduct")

	public String ladAddProduct() {
		return "admin/add_product";
	}

	@GetMapping("/category")

	public String category() {
		return "admin/category";
	}
}
