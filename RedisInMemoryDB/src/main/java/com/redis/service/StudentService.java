package com.redis.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.redis.model.Student;

@Service
public class StudentService {
	
	private final String KEY="STUDENT";
	
	@Resource(name="rt")
	private HashOperations<String, Integer, Student> op;
	
	public void addStudent(Student student) {
		
		op.putIfAbsent(KEY, student.getStdId(), student);
		
		
	}
	
	public void modifyStudent(Student s) {
	 op.put(KEY, s.getStdId(), s);
	}
	
	public Student getOneRec(Integer id) {
		return op.get(KEY, id);
	}
	
	public Map<Integer,Student> getAll(){
		return op.entries(KEY);
	}
	
	public void remove(Integer id) {
		op.delete(KEY, id);
	}

}
