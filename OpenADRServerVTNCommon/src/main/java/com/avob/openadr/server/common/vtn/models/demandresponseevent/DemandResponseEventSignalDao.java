package com.avob.openadr.server.common.vtn.models.demandresponseevent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DemandResponseEventSignalDao extends CrudRepository<DemandResponseEventSignal, Long> {

	public List<DemandResponseEventSignal> findByEvent(DemandResponseEvent event);

}
