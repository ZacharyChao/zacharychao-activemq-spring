package com.zacharychao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zacharychao.activemq.spring.producer.MyMessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-producer.xml")
public class ProducerTest {
	@Autowired
	private MyMessageProducer myMessageProducer;
	@Test
	public void testSendMessage() {
		for(int i = 0 ; i < 10 ; i ++) {
			myMessageProducer.sendMessage("" + i);
		}
	}
}
