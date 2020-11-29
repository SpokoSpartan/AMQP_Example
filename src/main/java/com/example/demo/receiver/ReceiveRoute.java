package com.example.demo.receiver;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("receiver")
public class ReceiveRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("rabbitmq://localhost:5672/xml.exchange?queue=xmlQueue&autoDelete=false")
				.unmarshal().json()
				.process(exchange -> System.out.println(exchange.getIn().getBody()));
	}

}
