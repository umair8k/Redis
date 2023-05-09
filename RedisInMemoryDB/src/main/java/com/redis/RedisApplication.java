package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redis.model.Student;
import com.redis.service.StudentService;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner{
	
	@Autowired
	private StudentService ser;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ser.addStudent(new Student(101,"Umair",12));
//		ser.addStudent(new Student(102,"Pk",5));
//		ser.addStudent(new Student(103,"AM",11));
		ser.addStudent(new Student(104,"fgfd dup",9));

		//ser.getAll().forEach((k,v)->System.out.println(k+"--------"+v));
		
		System.out.println("get One=============="+ser.getOneRec(104));
		
//		ser.modifyStudent(new Student(103,"aaaaaaaaaaaaa",11));
//		System.out.println("get Onem after modi=============="+ser.getOneRec(103));
//		
//		ser.remove(103);
//		System.out.println("removed 103i=============="+ser.getOneRec(103));
//		
	}

}
