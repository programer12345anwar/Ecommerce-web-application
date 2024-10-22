package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.model.Category;
import com.ecom.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CategoryService categoryService;

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

	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute Category category, HttpSession session) {
		Boolean existCategory = categoryService.existCategory(category.getName());
		if (existCategory) {

			session.setAttribute("errorMsg", "Category Name Already exist ");
		} else {
			Category saveCategory = categoryService.saveCategory(category);
			if (ObjectUtils.isEmpty(saveCategory)) {
				session.setAttribute("errorMsg", "Not saved ! internal server error");

			} else {
				session.setAttribute("succMsg", "saved successfully");

			}

		}

		categoryService.saveCategory(category);
		return "redirect:/category";
	}
}
