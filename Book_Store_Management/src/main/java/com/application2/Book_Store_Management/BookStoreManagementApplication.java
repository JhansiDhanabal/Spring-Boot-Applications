package com.application2.Book_Store_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.application2.Book_Store_Management.entity.BookStore;
import com.application2.Book_Store_Management.repository.BookRepository;

@SpringBootApplication
public class BookStoreManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementApplication.class, args);
	}
	@Autowired
	BookRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		BookStore book1 = new BookStore("data structue", "Fozljid", 250.0);
//		BookStore book2 = new BookStore("Let us C", "Resdljgl", 250.0);
//		BookStore book3 = new BookStore("Computer Networks", "Frozen", 250.0);
//		repository.save(book1);
//		repository.save(book2);
//		repository.save(book3);
	}

}
