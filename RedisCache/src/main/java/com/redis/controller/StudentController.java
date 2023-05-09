package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.model.Student;
import com.redis.service.StudentService;

import lombok.Delegate;

@RestController
@RequestMapping("/stud")
public class StudentController {
	
	@Autowired
	private StudentService ser;
	
	@PostMapping("/add")
	public ResponseEntity<?> addStud(@RequestBody Student stud){
		ser.addStudent(stud);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStud(@PathVariable Integer id){
		
		return new ResponseEntity<>(ser.getById(id),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		
		return new ResponseEntity<>(ser.getAll(),HttpStatus.CREATED);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student stud,@PathVariable Integer id){
		
		return new ResponseEntity<>(ser.update(id, stud),HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		ser.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
