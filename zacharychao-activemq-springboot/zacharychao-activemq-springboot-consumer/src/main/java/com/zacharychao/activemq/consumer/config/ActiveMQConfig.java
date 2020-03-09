package com.zacharychao.activemq.consumer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import com.zacharychao.activemq.consumer.handler.SomeHandler;

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
		return new ActiveMQConnectionFactory(this.user,this.password,this.broker_url);
	} 
	
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory,SomeHandler someHandler){
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		containerFactory.setErrorHandler(someHandler);
		return containerFactory;
	}
	
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
		listenerContainerFactory.setConnectionFactory(connectionFactory);
		listenerContainerFactory.setPubSubDomain(true);
		return listenerContainerFactory;
	}
	
}
