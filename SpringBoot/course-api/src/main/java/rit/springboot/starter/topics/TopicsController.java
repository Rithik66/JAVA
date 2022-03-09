  package rit.springboot.starter.topics;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topic")      //GET
	public List<Topics> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")      //GET Single 
	public Topics getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topic")    //POST
	public void addTopic(@RequestBody Topics topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topic/{id}")    //PUT
	public void UpdateTopic(@RequestBody Topics topic,@PathVariable String id) {
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topic/{id} ")    //DELETE
	public void DeleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}

