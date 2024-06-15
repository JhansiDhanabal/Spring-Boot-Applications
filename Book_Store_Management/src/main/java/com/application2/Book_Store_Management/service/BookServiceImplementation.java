package com.application2.Book_Store_Management.service;
import com.application2.Book_Store_Management.entity.*;
import com.application2.Book_Store_Management.repository.BookRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService{
	BookRepository repository;
	
	public BookServiceImplementation(BookRepository repository) {
		super();
		this.repository = repository;
	}

	public List<BookStore> getBookList(){
		return repository.findAll();
	}

	@Override
	public void addBook(BookStore st) {
		// TODO Auto-generated method stub
		repository.save(st);
	}

	@Override
	public BookStore getBookById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void deleteBook(BookStore st) {
		// TODO Auto-generated method stub
		repository.delete(st);
	}

	@Override
	public void saveUpdate(BookStore book) {
		// TODO Auto-generated method stub
		repository.save(book);
	}

}
