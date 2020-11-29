package com.example.demo.sender;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Profile("!receiver")
public class AsyncSender {

	@Produce("direct:send-to-mq")
	private ProducerTemplate template;

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Async
	public void sendWhenTyping() throws IOException, InterruptedException {
		while (true) {
			String name = reader.readLine();
			template.asyncSendBody(template.getDefaultEndpoint(), name);
		}
	}

}
