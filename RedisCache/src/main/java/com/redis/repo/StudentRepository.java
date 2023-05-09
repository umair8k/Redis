package com.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
