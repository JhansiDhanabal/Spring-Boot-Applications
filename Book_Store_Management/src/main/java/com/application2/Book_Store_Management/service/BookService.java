package com.application2.Book_Store_Management.service;

import java.util.List;

import com.application2.Book_Store_Management.entity.BookStore;


public interface BookService {
	public List<BookStore> getBookList();
	public void addBook(BookStore st);
	public BookStore getBookById(int id);
	public void deleteBook(BookStore st);
	public void saveUpdate(BookStore book);
}
