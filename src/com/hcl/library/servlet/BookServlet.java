package com.hcl.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.library.beans.Book;
import com.hcl.library.exception.BookException;
import com.hcl.library.services.BookServicesImpl;
import com.hcl.library.services.IBookServices;


@WebServlet("/")
public class BookServlet extends HttpServlet {
	

	private static final long serialVersionUID = -5459994792108004011L;
	private static int idNo;

	public BookServlet(){
		System.out.println("Inside Constructor");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("INIT method");
	}
	
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		
		String action=req.getServletPath();
		
		switch(action) {
		case "/add":
			addBook(req,res);
			break;
		case "/update":
			updateBook(req,res);
			break;
		case "/delete":
			deleteBook(req,res);
			break;	
		case "/fill":
			fillDetails(req,res);
			break;
		default:
			displayBook(req,res);
			break;
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		doGet(req,res);
	}
	
	protected void addBook(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		String title=req.getParameter("title");
		String author=req.getParameter("author");
		String price=req.getParameter("price");
		Book book=new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Float.parseFloat(price));
		
		try {
			IBookServices ibs=new BookServicesImpl();
			ibs.addBook(book);
			RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
			req.setAttribute("message", "Book added Successfully");
			rd.forward(req, res);

			
		} catch (BookException e) {
			RequestDispatcher rd=req.getRequestDispatcher("add.jsp");
			req.setAttribute("message",e.getMessage());
			rd.forward(req, res);
			e.printStackTrace();		}
	}
	
    protected void displayBook(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    	IBookServices ibs=new BookServicesImpl();
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		req.setAttribute("list",ibs.displayBook());
		rd.include(req, res);		
	}
    
  protected void fillDetails(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	    IBookServices ibs=new BookServicesImpl();
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		idNo=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("list",ibs.searchBook(idNo));
		rd.include(req, res);		
	}
   
    
 public void updateBook(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
          
		String title=req.getParameter("title");
		String author=req.getParameter("author");
		String price=req.getParameter("price");
		Book book=new Book();
		book.setId(idNo);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Float.parseFloat(price));
		IBookServices ibs=new BookServicesImpl();
		ibs.updateBook(book);
		req.setAttribute("message","Updated successfully");
		RequestDispatcher rd=req.getRequestDispatcher("display");
		rd.forward(req, res);
		
	}
 
 protected void deleteBook(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	 
 	
 	    int id=Integer.parseInt(req.getParameter("id"));
 		IBookServices ibs=new BookServicesImpl(); 
		if(ibs.deleteBook(id)) {
		req.setAttribute("message","Deleted successfully");
		}else {
			req.setAttribute("message","Already Deleted");
		}
		RequestDispatcher rd=req.getRequestDispatcher("display");
		rd.forward(req, res);
	}
	
	public void destroy() {
		System.out.println("Destroy Method");
	}


}
