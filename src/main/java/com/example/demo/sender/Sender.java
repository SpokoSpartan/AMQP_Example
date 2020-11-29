package com.example.demo.sender;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@Profile("!receiver")
public class Sender {

	private final AsyncSender sender;

	public Sender(AsyncSender sender) {
		this.sender = sender;
	}

	@PostConstruct
	public void send() throws IOException, InterruptedException {
			sender.sendWhenTyping();
	}

}
