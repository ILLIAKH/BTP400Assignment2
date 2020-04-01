//@author Illia Khomenko
package io.btp400.coursemanagement.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.btp400.coursemanagement.topic.Topic;

@RestController
public class CoursesController {
	
	@Autowired
	private CourseService courseService;
	
	//GET ALL BY TOPIC ID
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}	
	
	//GET ONE
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getOneCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	//CREATE NEW
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	//UPDATE
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
	
	//DELETE ALL
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/delete")
	public void deleteAllCourses()
	{
		courseService.deleteAll();
	}
	
	
}
