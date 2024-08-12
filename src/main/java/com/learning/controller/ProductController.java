package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learning.dao.ProductDAO;
import com.learning.entities.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/products")
	public ModelAndView productViewDetails() {
		ModelAndView model = new ModelAndView("productview");
		model.addObject("products", productDAO.getAllProducts());
		return model;
	}
	
	@PostMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("productview");
		boolean flag = productDAO.addProduct(product);
		if(flag) {
			//model.addObject("msg", "Product Added Successfully");
			model.addObject("products",productDAO.getAllProducts());
		}
		else {
			model.addObject("msg", "Failure");
		}
		return model;
	}

	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id) {
		
		 productDAO.deleteProductById(id);
		
		return "redirect:/products";
	}
}
