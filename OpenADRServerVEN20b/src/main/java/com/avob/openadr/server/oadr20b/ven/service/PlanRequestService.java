package com.avob.openadr.server.oadr20b.ven.service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.avob.openadr.client.http.oadr20b.ven.OadrHttpVenClient20b;
import com.avob.openadr.model.oadr20b.oadr.OadrCreateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrRegisterReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdateReportType;
import com.avob.openadr.server.oadr20b.ven.task.OadrCreateReportTask;
import com.avob.openadr.server.oadr20b.ven.task.OadrCreatedEventTask;
import com.avob.openadr.server.oadr20b.ven.task.OadrRegisterReportTask;
import com.avob.openadr.server.oadr20b.ven.task.OadrResponseTask;
import com.avob.openadr.server.oadr20b.ven.task.OadrUpdateReportTask;

@Service
public class PlanRequestService {

	private static final long DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS = 2;

	@Resource
	private ScheduledExecutorService scheduledExecutorService;

	public void submitCreatedEvent(OadrHttpVenClient20b client, OadrCreatedEventType payload) {
		scheduledExecutorService.schedule(new OadrCreatedEventTask(client, payload),
				DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS, TimeUnit.SECONDS);
	}

	public void submitResponse(OadrHttpVenClient20b client, OadrResponseType payload) {
		scheduledExecutorService.schedule(new OadrResponseTask(client, payload),
				DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS, TimeUnit.SECONDS);
	}

	public void submitRegisterReport(OadrHttpVenClient20b client, OadrRegisterReportType payload) {
		scheduledExecutorService.schedule(new OadrRegisterReportTask(client, payload),
				DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS, TimeUnit.SECONDS);
	}

	public void submitUpdateReport(OadrHttpVenClient20b client, OadrUpdateReportType payload) {
		scheduledExecutorService.schedule(new OadrUpdateReportTask(client, payload),
				DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS, TimeUnit.SECONDS);
	}

	public void submitCreateReport(OadrHttpVenClient20b client, OadrCreateReportType payload) {
		scheduledExecutorService.schedule(new OadrCreateReportTask(client, payload),
				DISTRIBUTE_EVENT_RESPONSE_DELAY_SECONDS, TimeUnit.SECONDS);
	}

}
