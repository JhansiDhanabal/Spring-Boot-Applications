package com.application.ecommerce_based_application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.application.ecommerce_based_application.dto.*;
import com.application.ecommerce_based_application.model.Category;
import com.application.ecommerce_based_application.model.Product;
import com.application.ecommerce_based_application.service.CategoryService;
import com.application.ecommerce_based_application.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin")
	public String adminhome() {
		return "adminHome";
	}
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	@GetMapping("/admin/categories/add")
	public String getCategoriesAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String saveCategoriesAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id ) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Optional<Category> cat = categoryService.getCategoryById(id);
		if(cat.isPresent()) {
			model.addAttribute("category", cat.get());
			return "categoriesAdd";
		}else
			return "484";
	}
	
	//Products
	@Autowired
	ProductService productService;
	
	@GetMapping("/admin/products/add")
	public String getproductsAdd(Model model) {
		model.addAttribute("productDTO", new ProductDAO());
		model.addAttribute("categories", categoryService.getAllCategory());
		
		return "productsAdd";
	}
public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	@PostMapping("/admin/products/add")
	public String productsAdd(@ModelAttribute("productDAO") ProductDAO productdao, 
	                          @RequestParam("productImage") MultipartFile file, 
	                          @RequestParam("imgName") String imgName) throws IOException {

	    Product product = new Product();
	    product.setId(productdao.getId());
	    product.setDescription(productdao.getDescription());
	    product.setName(productdao.getName());
	    product.setCategory(categoryService.getCategoryById(productdao.getCategoryId()).get());
	    product.setPrice(productdao.getPrice());
	    product.setWeight(productdao.getWeight());

	    String imgpath;
	    if (!file.isEmpty()) {
	        imgpath = file.getOriginalFilename();
	        Path uploadPath = Paths.get(uploadDir);
	        Path filepath = uploadPath.resolve(imgpath);
	        
	        // Create the directory if it does not exist
	        if (Files.notExists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }

	        Files.write(filepath, file.getBytes());
	        product.setImageName(imgpath);  // Save the new image name
	    } else {
	        imgpath = imgName;
	        product.setImageName(imgName);  // Use the existing image name
	    }

	    productService.addProduct(product);
	    return "redirect:/admin/products";
	}

	
	
	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProduct(@PathVariable long id, Model model) {
		Optional<Product> pro = productService.getProductById(id);
		if(pro.isPresent()) {
			Product product = pro.get();
			ProductDAO productdto = new ProductDAO();
			productdto.setId(product.getId());
			productdto.setName(product.getName());
			productdto.setCategoryId(product.getCategory().getId());
			productdto.setDescription(product.getDescription());
			productdto.setImageName(product.getImageName());
			productdto.setPrice(product.getPrice());
			productdto.setWeight(product.getWeight());
			model.addAttribute("productDTO", productdto);
			model.addAttribute("categories", categoryService.getAllCategory());
			return "productsAdd";
		}
		else
			return "484";
	}
}






