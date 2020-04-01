//@author Glib Zayarny
package io.btp400.coursemanagement.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
 
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("BTP400","Java","Java Course"),
			new Topic("BTP305","C++","C++ Course"),
			new Topic("BTS530","Project Impplementation","Project Implementation Course")
			));	 
	
	
	//GET ALL
	public List<Topic> getAllTopics()
	{
		List<Topic>topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	//GET ONE
	public Topic getTopic(String id)
	{
		return topicRepository.findById(id).get();
	}
	
	//CREATE NEW
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
	}
	
	//UPDATE
	public void updateTopic(String id, Topic topic)
	{
		topicRepository.save(topic);
	}
	
	//DELETE
	public void deleteTopic(String id)
	{
		topicRepository.deleteById(id);
	}
	
}
