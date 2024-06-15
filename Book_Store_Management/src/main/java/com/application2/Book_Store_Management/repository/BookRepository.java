package com.application2.Book_Store_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application2.Book_Store_Management.entity.BookStore;

public interface BookRepository extends JpaRepository<BookStore, Integer>{

}
