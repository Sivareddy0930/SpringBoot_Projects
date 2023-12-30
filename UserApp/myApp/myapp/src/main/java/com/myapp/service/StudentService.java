package com.myapp.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.Exception.StudentAlreadyExistsException;
import com.myapp.Exception.StudentNotFountExecption;
import com.myapp.Repository.StudentRepo;
import com.myapp.model.Student;

import lombok.RequiredArgsConstructor;
@Service
//@RequiredArgsConstructor
public class StudentService implements IStudentinterface {
	@Autowired
	private StudentRepo studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		if(studentAlreadyExists(student.getEmail())) {
			 throw new StudentAlreadyExistsException(student.getEmail()+"Email is already there");
		}
		return studentRepository.save(student);
	}



	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		
		return studentRepository.findById(id).map(st->
		{st.setName(student.getName());
		st.setEmail(student.getEmail());
		return studentRepository.save(st);
		}).orElseThrow(()-> new StudentNotFountExecption("specified student is not there"));
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFountExecption("no student found with this id :-"+id));
//		if(s.isPresent()) {
//			return s.get();
//		}
//		 throw new StudentNotFountExecption("no student found with this id :-"+id);
	}

	@Override
	public void deleteStudent(Long id) {
		
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFountExecption("no student found with this id :-"+id);
		}
		studentRepository.deleteById(id);

	}
	
	private boolean studentAlreadyExists(String email) {

		return studentRepository.findByEmail(email).isPresent();
	}

}
