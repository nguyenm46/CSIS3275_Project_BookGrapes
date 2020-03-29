package com.user.wongi5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.user.wongi5.model.Book;

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

	public List<Book> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM books";

		List<Book> result = namedParameterJdbcTemplate.query(sql, params, new BookMapper());

		return result;
	}

	private static final class BookMapper implements RowMapper<Book> {

		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
//			user.setId(rs.getInt("id"));
			book.setCode(rs.getString("code"));
			book.setBooktitle(rs.getString("name"));
			return book;
		}
	}
}
