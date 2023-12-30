package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Student;
import com.myapp.service.IStudentinterface;
import lombok.RequiredArgsConstructor;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
//@RequiredArgsConstructor
public class StudentControlller {
	@Autowired
	private IStudentinterface studentService;
	
	
@PostMapping
public Student addStudent(@RequestBody Student student) {
	return studentService.addStudent(student);	
}

	
@GetMapping
public ResponseEntity<List<Student>> getAllStudents(){
	return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	
}

@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id){
return studentService.getStudentById(id);

}
@PutMapping("/update/{id}")
public Student updateStudent(@RequestBody Student student,@PathVariable Long id) {
	return studentService.updateStudent(student, id);
	
}
@DeleteMapping("/delete/{id}")
public void deleteStudent(@PathVariable Long id) {
	 studentService.deleteStudent(id);
	
}

}
