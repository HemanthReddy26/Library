package com.hcl.library.services;

import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.exception.BookException;



public interface IBookServices {

	
public Book addBook(Book book) throws BookException;
	
	public boolean updateBook(Book book);

	public boolean deleteBook(int id);

	public List<Book> searchBook(int id);
	
	public List<Book> displayBook();
}
