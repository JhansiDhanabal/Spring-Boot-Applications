package com.application2.Book_Store_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application2.Book_Store_Management.entity.MyBookList;
import com.application2.Book_Store_Management.repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	MyBookRepository repository;
	
	public void saveBook(MyBookList mybook) {
		repository.save(mybook);
	}
	public List<MyBookList> showall(){
		return repository.findAll();
	}
	public MyBookList getBookById(int id) {
		return repository.getById(id);
	}
	public void deleteBook(MyBookList book) {
		repository.delete(book);
	}
}
