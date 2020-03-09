package com.zacharychao.activemq.producer.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootConfiguration
public class ActiveMQConfig {
	
	@Value("${spring.activemq.broker-url}")
	private String broker_url;
	@Value("${spring.activemq.user}")
	private String user;
	@Value("${spring.activemq.password}")
	private String password;
	@Value("${queue.name}")
	private String queueName;
	@Value("${topic.name}")
	private String topicName;
	
	@Bean
	public ActiveMQQueue queue() {return new ActiveMQQueue(this.queueName);}
	
	@Bean
	public ActiveMQTopic topic() {return new ActiveMQTopic(this.topicName);}
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(this.user,this.password,this.broker_url);
		return activeMQConnectionFactory;
	} 
	
	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactoryQueue(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		return containerFactory;
	}
	
	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactoryTopic(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		containerFactory.setPubSubDomain(true);
		return containerFactory;
	}
}
