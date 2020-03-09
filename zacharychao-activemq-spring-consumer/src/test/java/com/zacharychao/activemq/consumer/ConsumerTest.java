package com.zacharychao.activemq.consumer;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-consumer.xml")
public class ConsumerTest {
	@Test
	public void testConsumer() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
