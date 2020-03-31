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
import com.user.nguyenm46.model.Publisher;
//Hsueh-Cheng Liu 300280496 

@Repository
public class PublisherDaoImpl implements PublisherDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Publisher findByEmail(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);

		String sql = "SELECT * FROM publishers WHERE email=:email";

		List<Publisher> results = namedParameterJdbcTemplate.query(sql, params, new PublisherMapper());

		if (results.size() == 0) {
			return null;
		}
		Publisher publisher = results.get(0);

		List<Book> bookResults = findPublishedBooks(publisher.getEmail());

		publisher.setBooklist(bookResults);

		return publisher;
	}

	public int publishedBookByBookCode(String email, String code) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("code", code);

		String sql = "INSERT INTO publishedbooklist VALUES(:email, :code)";
		return namedParameterJdbcTemplate.update(sql, params);
	}

	public List<Book> findPublishedBooks(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);

		String sql = "SELECT * FROM publishedbooklist r, books b WHERE r.email=:email AND r.code=b.code;";

		List<Book> bookResults = namedParameterJdbcTemplate.query(sql, params, new BookMapper());

		return bookResults;
	}

	private static final class PublisherMapper implements RowMapper<Publisher> {

		public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
			Publisher publisher = new Publisher();
			publisher.setName(rs.getString("name"));
			publisher.setEmail(rs.getString("email"));
			publisher.setPassword(rs.getString("password"));
			return publisher;
		}
	}

	private static final class BookMapper implements RowMapper<Book> {

		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setCode(rs.getString("code"));
			book.setBooktitle(rs.getString("name"));
			return book;
		}
	}

	public List<Publisher> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM publishers";

		List<Publisher> result = namedParameterJdbcTemplate.query(sql, params, new PublisherMapper());

		return result;
	}

	public boolean addPublisher(Publisher publisher) {
		String sql = "insert into publishers values('" + publisher.getEmail() + "','"
				+ publisher.getName() + "','"+ publisher.getPassword() + "')";
		Map<String, Object> params = new HashMap<String, Object>();
		boolean result = namedParameterJdbcTemplate.update(sql, params) == 1;
		return result;
	}

}
