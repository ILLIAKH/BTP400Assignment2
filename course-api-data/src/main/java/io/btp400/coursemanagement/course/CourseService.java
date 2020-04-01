//@author Illia Khomenko
package io.btp400.coursemanagement.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
 
	@Autowired
	private CourseRepository courseRepository;
	
	//GET ALL
	public List<Course> getAllCourses(String topicId)
	{
		List<Course>topics = new ArrayList<>();
		courseRepository.findAllByTopicId(topicId).forEach(topics::add);
		return topics;
	}
	//GET ONE
	public Course getCourse(String id)
	{
		return courseRepository.findById(id).get();
	}
	
	//CREATE NEW
	public void addCourse(Course course)
	{
		courseRepository.save(course);
	}
	
	//UPDATE
	public void updateCourse(Course course)
	{
		courseRepository.save(course);
	}
	
	//DELETE
	public void deleteCourse(String id)
	{
		courseRepository.deleteById(id);
	}
	
	//DELETE ALL
	public void deleteAll()
	{
		courseRepository.deleteAll();
	}
	
}
