package io.btp400.coursemanagement.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findAllByTopicId(String topicId);
	
}