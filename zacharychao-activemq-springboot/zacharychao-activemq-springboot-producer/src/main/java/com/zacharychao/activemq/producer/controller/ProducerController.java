package com.zacharychao.activemq.producer.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private ActiveMQTopic topic;
	@PostMapping("/queue")
	public void send() {
		for(int i = 0 ; i < 10 ; i ++) {
			jmsTemplate.convertAndSend(queue, "queue*****" + i);
		}
	}
}
