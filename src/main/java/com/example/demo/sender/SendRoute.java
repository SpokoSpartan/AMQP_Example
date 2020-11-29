package com.example.demo.sender;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!receiver")
public class SendRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:send-to-mq")
				.id("rabbit-mq")
				.marshal().json()
				.to("rabbitmq://localhost:5672/xml.exchange?queue=xmlQueue&autoDelete=false");
	}

}
