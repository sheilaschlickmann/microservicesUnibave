package com.sheila.springproject.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sheila.springproject.dto.ClientDTO;

@Component
public class ClientListener {

	private static Logger logger = LoggerFactory.getLogger(ClientListener.class);
	
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@RabbitListener(queues = "client")
	public void onListenClient(@Payload ClientDTO clientDto) {
		System.out.println(clientDto);
		logger.info("Lendo fila client " + clientDto);

	}

}
