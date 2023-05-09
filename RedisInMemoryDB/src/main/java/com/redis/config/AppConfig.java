package com.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.redis.model.Student;

@Configuration
public class AppConfig {
	
	@Bean
	public RedisConnectionFactory cf() {
		return new LettuceConnectionFactory();
	}
	@Bean
	public RedisTemplate<Integer, Student> rt(){
		RedisTemplate<Integer,Student > temp=new RedisTemplate<Integer, Student>();
		temp.setConnectionFactory(cf());
		return temp;
	}

}
