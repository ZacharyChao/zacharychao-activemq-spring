package com.zacharychao.activemq.consumer.handler;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;
@Component
public class SomeHandler implements ErrorHandler{

	public void handleError(Throwable t) {
		System.out.println(t.getMessage());
	}

}
