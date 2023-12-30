package com.myapp.service;

import java.util.List;

import com.myapp.model.Student;

public interface IStudentinterface {
	
	Student addStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student updateStudent(Student student,Long id);
	
	Student getStudentById(Long id);
	
	void deleteStudent(Long id);
	
}
