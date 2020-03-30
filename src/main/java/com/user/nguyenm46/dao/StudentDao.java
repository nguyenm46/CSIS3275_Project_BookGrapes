package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Course;
import com.user.nguyenm46.model.Student;

 
public interface StudentDao {

	Student findByEmail(String email);
	
	int registerCourseByCourseCode(String email, String code);
	
	List<Course> findRegisteredCourses(String email);

}
