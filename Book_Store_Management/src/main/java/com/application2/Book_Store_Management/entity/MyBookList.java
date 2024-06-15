package com.application2.Book_Store_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyBookList")
public class MyBookList {
	@Id
	private int book_id;
	private String book_title;
	private String author_name;
	private double price;
	public MyBookList() {
		
	}
	public MyBookList(int book_id, String book_title, String author_name, double price) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.author_name = author_name;
		this.price = price;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
