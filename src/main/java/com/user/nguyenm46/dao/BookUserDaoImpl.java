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
import com.user.nguyenm46.model.BookUser;

//Hsueh-Cheng Liu 300280496 

@Repository
public class BookUserDaoImpl implements BookUserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public BookUser findByEmail(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);

		String sql = "SELECT * FROM bookusers WHERE email=:email";

		List<BookUser> results = namedParameterJdbcTemplate.query(sql, params, new BookUserMapper());

		if (results.size() == 0) {
			return null;
		}
		BookUser bookuser = results.get(0);

		List<Book> bookResults = findRegisteredBooks(bookuser.getEmail());

		bookuser.setBooklist(bookResults);

		return bookuser;
	}

	public int registerBookByBookCode(String email, String code) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("code", code);

		String sql = "INSERT INTO user_booklists VALUES(:email, :code)";
		return namedParameterJdbcTemplate.update(sql, params);
	}

	public List<Book> findRegisteredBooks(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);

		String sql = "SELECT * FROM user_booklists r, books b WHERE r.email=:email AND r.code=b.code;";

		List<Book> bookResults = namedParameterJdbcTemplate.query(sql, params, new BookMapper());

		return bookResults;
	}

	private static final class BookUserMapper implements RowMapper<BookUser> {

		public BookUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookUser bookuser = new BookUser();
			bookuser.setUsername(rs.getString("username"));
			bookuser.setEmail(rs.getString("email"));
			bookuser.setPassword(rs.getString("password"));

			bookuser.setFullname(rs.getString("fullname"));
			bookuser.setDob(rs.getString("dob"));
			return bookuser;
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

	public List<BookUser> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM bookusers";

		List<BookUser> result = namedParameterJdbcTemplate.query(sql, params, new BookUserMapper());

		return result;
	}

	public boolean addBookUser(BookUser bookUser) {
		String sql = "insert into bookusers values('" + bookUser.getEmail() + "','"
				+ bookUser.getUsername() + "','" + bookUser.getFullname() + "','" + bookUser.getDob() + "','"
				+ bookUser.getPassword() + "')";
		Map<String, Object> params = new HashMap<String, Object>();
		boolean result = namedParameterJdbcTemplate.update(sql, params) == 1;
		return result;
	}
}
