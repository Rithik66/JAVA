package rit.springboot.starter.topics;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	List<Topics> topics = new ArrayList<Topics>(Arrays.asList(
			new Topics("1","Ram","Student"),
			new Topics("2","Raj","Student"),
			new Topics("3","Prem","Student")
	));
	public List<Topics> getAllTopics(){
		List<Topics> topics = (List<Topics>)topicRepository.findAll();
		return topics;
	}

	public Topics getTopic(String id) {
		for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equals(id)) return topics.get(i);
		}
		return new Topics();
	}

	public void addTopic(Topics topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topics topic,String id) {
		for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i,topic);
				return;
			} 
		}	
	}
	public void deleteTopic(String id) {
		topics.remove(topics.indexOf(id));
		return;
	}
}
