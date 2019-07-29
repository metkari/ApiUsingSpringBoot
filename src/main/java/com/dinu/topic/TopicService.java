package com.dinu.topic;

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
			
			new Topic("101", "java", "good prog language"),
			new Topic("102", "dot net", "quality gui prog"),
			new Topic("103", "pyhon", "osm prog language")
			
			));
	
	public List<Topic> getAllTopics() {
		
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
	
	//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
		topicRepository.save(topic);
			
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}

	

	

}
