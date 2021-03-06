package com.avob.openadr.server.common.vtn.service.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VenCommandPublisher {

	public static final String OADR20B_QUEUE = "queue.command.oadr20b";

	@Autowired
	private JmsTemplate jmsTemplate;

	private ObjectMapper mapper = new ObjectMapper();

	public <T> void publish(String venUsername, String venPushUrl, Boolean xmlSignature, String payload, Class<T> klass)
			throws JsonProcessingException {
		VenCommandDto<T> command = new VenCommandDto<T>();
		command.setVenUsername(venUsername);
		command.setVenPushUrl(venPushUrl);
		command.setXmlSignature(xmlSignature);
		command.setPayload(payload);
		command.setPayloadClass(klass);

		try {
			jmsTemplate.convertAndSend(OADR20B_QUEUE, mapper.writeValueAsString(command));
		} catch (JmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
