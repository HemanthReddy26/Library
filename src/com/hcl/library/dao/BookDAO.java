package com.hcl.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.library.beans.Book;
import com.hcl.library.exception.BookException;
import com.hcl.library.util.DBConnection;

public class BookDAO {

	public boolean isDataPresent(int id) {

		Connection con = DBConnection.getConnection();
		boolean boolValue = false;
		String query = "select count(*) from library where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 0)
					boolValue = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeResultSet(rs);
		}

		return boolValue;
	}

	public Book addBook(Book book) throws BookException {

		if (isDataPresent(book.getId())) {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = null;
			String sql = "insert into library values(?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, book.getId());
				ps.setString(2, book.getTitle());
				ps.setString(3, book.getAuthor());
				ps.setFloat(4, book.getPrice());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBConnection.closePreparedStatement(ps);
			}
			return book;
		} else
			throw new BookException("Id already exists.Please enter another id.");

	}

	public boolean updateBook(Book book) {

		boolean rowUpdated = false;
		Connection con =DBConnection.getConnection();
		String updateQuery = "update library set title=?,author=?,price=? where id=?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(updateQuery);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setFloat(3, book.getPrice());
			ps.setInt(4, book.getId());
			rowUpdated = ps.executeUpdate()>0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(ps);
		}
		
		return rowUpdated; 
	}    

	public boolean deleteBook(int id) {

		boolean rowDeleted = false;
		Connection con = DBConnection.getConnection();

		String deleteQuery = "delete from library where id=?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			rowDeleted =ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(ps);
		}
		return rowDeleted;

	}

	public List<Book> searchBook(int id){
		
		Connection con = DBConnection.getConnection();
		String searchQuery = "select id,title,author,price from library where id=?";
		List<Book> bookList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(searchQuery);
			ps.setInt(1,id);

			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getFloat(4));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeResultSet(rs);
		}
		return bookList;
	}

	public List<Book> displayBook() {
		Connection con = DBConnection.getConnection();

		String sql = "select id,title,author,price from library";
		List<Book> bookList = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getFloat(4));

				bookList.add(book);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(stmt);
			DBConnection.closeResultSet(rs);
		}

		return bookList;

	}

}
