package com.myapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

	Optional<Student> findByEmail(String Email);

}
