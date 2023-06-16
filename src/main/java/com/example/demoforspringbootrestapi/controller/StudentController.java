package com.example.demoforspringbootrestapi.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoforspringbootrestapi.entity.student;
import com.example.demoforspringbootrestapi.repository.StudentRepo;



@RestController
public class StudentController {
	@Autowired
	StudentRepo studentrepo;
	
	@PostMapping("/api/students")
	public ResponseEntity<student> saveStudent(@RequestBody student Student) {
		return new ResponseEntity<>(studentrepo.save(Student),HttpStatus.CREATED);
	}
	@GetMapping("/api/students")
	public ResponseEntity<List<student>> getStudents() {
		return new ResponseEntity<>(studentrepo.findAll(),HttpStatus.OK);
		
	
		
	}
	@GetMapping("/api/students/{id}")
	public ResponseEntity<student> getStudent(@PathVariable long id) {
		Optional<student> Student = studentrepo.findById(id);
		if(Student.isPresent()) {
			return new ResponseEntity<>(Student.get(),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
	
		
	}	
	@PutMapping("/api/students/{id}")
	public ResponseEntity<student> updateStudent(@PathVariable long id,@RequestBody student stud) {
		Optional<student> Student = studentrepo.findById(id);
		if(Student.isPresent()) {
			Student.get().setStudentName(stud.getStudentName());
			Student.get().setStudentEmail(stud.getStudentEmail());
			Student.get().setStudentAddress(stud.getStudentAddress());
			return new ResponseEntity<>(studentrepo.save(Student.get()),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
	
		
	}
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id,@RequestBody student stud) {
		Optional<student> Student = studentrepo.findById(id);
		if(Student.isPresent()) {
			studentrepo.deleteById(id);
			
		
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	
	
		
	}
}


