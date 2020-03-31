package io.btp400;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.btp400.coursemanagement.course.Course;
import io.btp400.coursemanagement.course.CourseRepository;
import io.btp400.coursemanagement.topic.Topic;
import io.btp400.coursemanagement.topic.TopicRepository;

@SpringBootApplication

public class CourseApiDataApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(CourseRepository courseRepository, TopicRepository topicRepository) {
	    return (args) -> {
	    	topicRepository.save(new Topic("Java","Java Topic","About Java"));
	    	topicRepository.save(new Topic("C++","C++ Topic","About C++"));
	    	courseRepository.save(new Course("BTP400","Java Course","Peter Liu","Java"));
	    	courseRepository.save(new Course("BTP305","C++ Course","Cornel Barna","C++"));
	    };
	}
	
}
