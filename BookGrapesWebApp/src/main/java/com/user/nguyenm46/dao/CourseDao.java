package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Course;
 
public interface CourseDao {

	Course findByCode(String name);
	 
	List<Course> findAll();

}
