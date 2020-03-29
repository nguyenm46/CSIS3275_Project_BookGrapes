package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.User;

 
public interface UserDao {

	User findByName(String name);
	 
	List<User> findAll();

}
