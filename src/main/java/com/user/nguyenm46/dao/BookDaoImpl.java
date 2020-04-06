package com.user.nguyenm46.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.nguyenm46.model.Book;

//Hsueh-Cheng Liu 300280496 

@Repository
public class BookDaoImpl implements BookDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Book findByCode(String code) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);

		String sql = "SELECT * FROM books WHERE code=:code";
		Book result = namedParameterJdbcTemplate.queryForObject(sql, params, new BookMapper());

		return result;
	}

	public Book findByTitle(String booktitle) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("booktitle", booktitle);

		String sql = "SELECT * FROM books WHERE booktitle=:booktitle";
		Book result = namedParameterJdbcTemplate.queryForObject(sql, params, new BookMapper());

		return result;
	}

	public List<String> searchUserReview(String code) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		String sql = "SELECT * FROM bookreviews WHERE code=:code";

		List<String> result = namedParameterJdbcTemplate.query(sql, params, new ReviewMapper());

		return result;
	}

	public List<Book> findAll() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM books";

		List<Book> result = namedParameterJdbcTemplate.query(sql, params, new BookMapper());

		return result;
	}

	private static final class BookMapper implements RowMapper<Book> {

		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setCode(rs.getString("code"));
			book.setBooktitle(rs.getString("booktitle"));
			book.setAuthor(rs.getString("author"));
			book.setPublishedyear(rs.getString("publishedyear"));
			return book;
		}
	}

	private static final class ReviewMapper implements RowMapper<String> {

		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String review = rs.getString("review");
			return review;
		}
	}

	public boolean addBook(Book book, String size) {
		String sql = "insert into books values('" + size + "','" + book.getBooktitle() + "','" + book.getAuthor()
				+ "','" + book.getPublishedyear() + "')";
		Map<String, Object> params = new HashMap<String, Object>();
		boolean result = namedParameterJdbcTemplate.update(sql, params) == 1;
		return result;
	}

	public boolean addBookReview(String code, String email, String review) {
		String sql = "insert into bookreviews values('" + email + "','" + code + "','" + review + "')";
		Map<String, Object> params = new HashMap<String, Object>();
		boolean result = namedParameterJdbcTemplate.update(sql, params) == 1;
		return result;
	}

	public boolean editbook(Book book) {
		Book updateBook = findByCode(book.getCode());
		String booktitle = null, author = null, publishedyear = null;

		if (book.getAuthor() == null)
			author = updateBook.getAuthor();
		else
			author = book.getAuthor();

		if (book.getBooktitle() == null)
			booktitle = updateBook.getBooktitle();
		else
			booktitle = book.getBooktitle();

		if (book.getPublishedyear() == null)
			publishedyear = updateBook.getPublishedyear();
		else
			publishedyear = book.getPublishedyear();

		String sql = "update books set " + "booktitle='" + booktitle + "'," + "author='" + author + "',"
				+ "publishedyear='" + publishedyear + "'" + "where code='" + book.getCode() + "'";
		Map<String, Object> params = new HashMap<String, Object>();
		boolean result = namedParameterJdbcTemplate.update(sql, params) == 1;
		return result;
	}

}
