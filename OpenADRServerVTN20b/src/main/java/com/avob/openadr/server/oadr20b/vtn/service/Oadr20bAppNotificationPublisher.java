package com.avob.openadr.server.oadr20b.vtn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.avob.openadr.server.common.vtn.service.push.OadrAppNotificationPublisher;
import com.avob.openadr.server.oadr20b.vtn.service.dtomapper.Oadr20bDtoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Oadr20bAppNotificationPublisher {

	@Resource
	private OadrAppNotificationPublisher oadrAppNotificationPublisher;

	@Resource
	private Oadr20bDtoMapper oadr20bDtoMapper;

	private ObjectMapper mapper = new ObjectMapper();

	public <T> void convertAndNotify(Object po, Class<T> klass) {
		try {
			T map = oadr20bDtoMapper.map(po, klass);
			oadrAppNotificationPublisher.notify(mapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void notify(Object dto) {
		try {
			oadrAppNotificationPublisher.notify(mapper.writeValueAsString(dto));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
