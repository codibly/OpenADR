package com.avob.openadr.model.oadr20b.builders;

import javax.xml.bind.JAXBElement;

import com.avob.openadr.model.oadr20b.avob.PayloadAvobVenServiceRequestType;
import com.avob.openadr.model.oadr20b.avob.PayloadKeyTokenType;
import com.avob.openadr.model.oadr20b.builders.eipayload.Oadr20bEiTargetTypeBuilder;
import com.avob.openadr.model.oadr20b.builders.eipayload.Oadr20bReportIntervalTypeBuilder;
import com.avob.openadr.model.oadr20b.builders.eipayload.Oadr20bSignalIntervalTypeBuilder;
import com.avob.openadr.model.oadr20b.ei.PayloadBaseType;
import com.avob.openadr.model.oadr20b.oadr.OadrPayloadResourceStatusType;

public class Oadr20bEiBuilders {

	public static Oadr20bEiTargetTypeBuilder newOadr20bEiTargetTypeBuilder() {
		return new Oadr20bEiTargetTypeBuilder();
	}

	public static Oadr20bSignalIntervalTypeBuilder newOadr20bSignalIntervalTypeBuilder(String intervalId, long dtstart,
			String xmlDuration, Float value) {
		return new Oadr20bSignalIntervalTypeBuilder(intervalId, dtstart, xmlDuration, value);
	}

	public static Oadr20bReportIntervalTypeBuilder newOadr20bReportIntervalTypeBuilder(String intervalId, long start,
			String xmlDuration, String rid, Long confidence, Float accuracy, Float value) {
		return new Oadr20bReportIntervalTypeBuilder(intervalId, start, xmlDuration, rid, confidence, accuracy, value);
	}

	public static Oadr20bReportIntervalTypeBuilder newOadr20bReportIntervalTypeBuilder(String intervalId, long start,
			String xmlDuration, String rid, Long confidence, Float accuracy, PayloadKeyTokenType tokens) {
		return new Oadr20bReportIntervalTypeBuilder(intervalId, start, xmlDuration, rid, confidence, accuracy, tokens);
	}

	public static Oadr20bReportIntervalTypeBuilder newOadr20bReportIntervalTypeBuilder(String intervalId, long start,
			String xmlDuration, String rid, Long confidence, Float accuracy,
			PayloadAvobVenServiceRequestType requests) {
		return new Oadr20bReportIntervalTypeBuilder(intervalId, start, xmlDuration, rid, confidence, accuracy,
				requests);
	}

	public static Oadr20bReportIntervalTypeBuilder newOadr20bReportIntervalTypeBuilder(String intervalId, long start,
			String xmlDuration, String rid, Long confidence, Float accuracy, OadrPayloadResourceStatusType value) {
		return new Oadr20bReportIntervalTypeBuilder(intervalId, start, xmlDuration, rid, confidence, accuracy, value);
	}

	public static Oadr20bReportIntervalTypeBuilder newOadr20bReportIntervalTypeBuilder(String intervalId, long start,
			String xmlDuration, String rid, Long confidence, Float accuracy,
			JAXBElement<? extends PayloadBaseType> payloadBase) {
		return new Oadr20bReportIntervalTypeBuilder(intervalId, start, xmlDuration, rid, confidence, accuracy,
				payloadBase);
	}
}
