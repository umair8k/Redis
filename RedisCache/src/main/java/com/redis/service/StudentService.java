package com.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.model.Student;
import com.redis.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	
	public void addStudent(Student stud) {
		this.studentRepository.save(stud);
	}
	
	@Cacheable(value="student",key = "#id")
	public Student getById(Integer  id) {
		
		return this.studentRepository.findById(id).orElseThrow();
	}
	public List<Student> getAll(){
		return this.studentRepository.findAll();
	}
	@CacheEvict(value="student",key="#id")
	public void delete(Integer id) {
		this.studentRepository.delete(getById(id));
	}
	@CachePut(value="student",key = "#id")
	public Student update(Integer id,Student stud) {
	  Student s=	getById(id);
	  s.setName(stud.getName());
	  s.setStd(stud.getStd());
	  return this.studentRepository.save(s);
	}
}
