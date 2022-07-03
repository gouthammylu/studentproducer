package com.kafka.practice.studentproducer.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.practice.dto.Student;

@RestController
@RequestMapping("student")
public class MainController {
	
	@Autowired
	private KafkaTemplate<Integer, Student> kafkaTemplate;
	
	@PostMapping("save")
	public void saveStudent(@RequestBody Student student) {
		
		ProducerRecord<Integer,Student> producerRecord=new ProducerRecord<Integer, Student>("StudentTopic",student.getRollnumber(),student);	
		kafkaTemplate.send(producerRecord);
		
	}

}
