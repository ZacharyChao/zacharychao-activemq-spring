package com.zacharychao.activemq.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
	@JmsListener(destination="queue_name_001",containerFactory="jmsListenerContainerQueue")
	public void receive(String text) {
		System.out.println(text);
	}
}
