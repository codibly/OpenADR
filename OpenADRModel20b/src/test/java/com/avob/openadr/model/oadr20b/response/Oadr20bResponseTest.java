package com.avob.openadr.model.oadr20b.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;

import com.avob.openadr.model.oadr20b.Oadr20bFactory;
import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.builders.Oadr20bResponseBuilders;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bUnmarshalException;
import com.avob.openadr.model.oadr20b.oadr.OadrDistributeEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrResponseType;

public class Oadr20bResponseTest {

	private Oadr20bJAXBContext jaxbContext;

	public Oadr20bResponseTest() {
		try {
			jaxbContext = Oadr20bJAXBContext.getInstance();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void marshalTest() throws DatatypeConfigurationException, Oadr20bMarshalException {
		String requestId = null;
		Integer responseCode = 200;
		String responseDescription = "";
		String venId = "venId";
		OadrResponseType response = Oadr20bResponseBuilders.newOadr20bResponseBuilder(requestId, responseCode, venId)
				.withDescription(responseDescription).build();

		boolean assertion = false;
		try {
			jaxbContext.marshalRoot(response, true);
		} catch (Oadr20bMarshalException e) {
			assertion = true;
		}

		assertTrue(assertion);

		File file = new File("src/test/resources/response/unvalidatingOadrResponse.xml");
		assertion = false;
		try {
			jaxbContext.unmarshal(file, OadrDistributeEventType.class);
		} catch (Oadr20bUnmarshalException e) {
			assertion = true;
		}
		assertTrue(assertion);

	}

	@Test
	public void unmarshalTest() throws Oadr20bUnmarshalException, Oadr20bMarshalException {

		File file = new File("src/test/resources/response/oadrResponse.xml");
		OadrResponseType unmarshal = jaxbContext.unmarshal(file, OadrResponseType.class);
		assertNotNull(unmarshal.getEiResponse());
		assertEquals("200", unmarshal.getEiResponse().getResponseCode());
		assertEquals("OK", unmarshal.getEiResponse().getResponseDescription());
		assertEquals("REQ_12345", unmarshal.getEiResponse().getRequestID());

		File file2 = new File("src/test/resources/response/genOadrResponse.xml");
		jaxbContext.marshal(Oadr20bFactory.createOadrResponse(unmarshal), file2);
		assertTrue(file2.exists());
		file2.delete();

	}
}
