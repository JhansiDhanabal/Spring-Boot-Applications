package com.application.ecommerce_based_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.ecommerce_based_application.global.GlobalData;
import com.application.ecommerce_based_application.model.Product;
import com.application.ecommerce_based_application.service.ProductService;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
    	GlobalData.cart.add(productService.getProductById(id).get());
    	return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkOut(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
    
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
    	GlobalData.cart.remove(index);
    	return "redirect:/cart";
    }

   
}
