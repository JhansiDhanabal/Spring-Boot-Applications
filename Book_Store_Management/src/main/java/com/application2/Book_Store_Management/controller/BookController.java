package com.application2.Book_Store_Management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application2.Book_Store_Management.entity.BookStore;
import com.application2.Book_Store_Management.entity.MyBookList;
import com.application2.Book_Store_Management.service.BookService;
import com.application2.Book_Store_Management.service.MyBookService;

@Controller
public class BookController {
	BookService service;
	MyBookService mybookservice;
	public BookController(BookService service, MyBookService se) {
		super();
		this.service = service;
		this.mybookservice = se;
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Home";
	}
	@GetMapping("/books")
	public String showList(Model model) {
		List<BookStore> books = service.getBookList();
		model.addAttribute("books", books);
		return "show-books";
	}
	@GetMapping("/book/new")
	public String addbooks(Model model) {
		BookStore book = new BookStore();
		model.addAttribute("book", book);
		return "entry-form";
	}
	@PostMapping("/bookUpdate")
	public String updateBook(@ModelAttribute("book") BookStore bs) {
		service.addBook(bs);
		return "redirect:/books";
	}
	@GetMapping("/book/edit/{id}")
	public String editBook(@PathVariable int id, Model model) {
		BookStore st = service.getBookById(id);
		model.addAttribute("book",st);
		return "update-form";
	}
	@PostMapping("/book/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute("book") BookStore bs) {
		BookStore ds = service.getBookById(id);
		ds.setId(bs.getId());
		ds.setAuthor(bs.getAuthor());
		ds.setName(bs.getName());
		ds.setPrice(bs.getPrice());
		service.saveUpdate(ds);
		return "redirect:/books";
	}
	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable int id, Model model) {
		BookStore st = service.getBookById(id);
		service.deleteBook(st);
		return "redirect:/books";
	}
	@GetMapping("/showMyBooks")
	public String showmybook(Model model) {
		List<MyBookList> mybooks = mybookservice.showall();
		model.addAttribute("mybooks", mybooks);
		return "show-mybooks";
	}
	@GetMapping("/MyBooks/new/{id}")
	public String addmybook(@PathVariable int id) {
		BookStore st = service.getBookById(id);
		MyBookList mybook = new MyBookList(st.getId(), st.getName(), st.getAuthor(), st.getPrice());
		mybookservice.saveBook(mybook);
		return "redirect:/showMyBooks";
	}
	@GetMapping("/mybook/delete/{id}")
	public String deletemybook(@PathVariable int id) {
		MyBookList mybook = mybookservice.getBookById(id);
		mybookservice.deleteBook(mybook);
		return "redirect:/showMyBooks";
	}
}
	
