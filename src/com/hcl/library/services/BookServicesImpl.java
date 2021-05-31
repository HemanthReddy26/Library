package com.hcl.library.services;

import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.dao.BookDAO;
import com.hcl.library.exception.BookException;

public class BookServicesImpl implements IBookServices {

	@Override
	public Book addBook(Book book) throws BookException {
		BookDAO dao=new BookDAO();
		return dao.addBook(book);
	}

	@Override
	public boolean updateBook(Book book) {
		BookDAO dao=new BookDAO();
		return dao.updateBook(book);
		
	}

	@Override
	public boolean deleteBook(int id) {
		BookDAO dao=new BookDAO();
		return dao.deleteBook(id);
	}

	@Override
	public List<Book> searchBook(int id){
		BookDAO dao=new BookDAO();
		return dao.searchBook(id);
	}

	@Override
	public List<Book> displayBook() {
		BookDAO dao=new BookDAO();
		return dao.displayBook();
	}
}
