package com.avob.openadr.model.oadr20b.eiregisterparty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;

import com.avob.openadr.model.oadr20b.Oadr20bFactory;
import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiRegisterPartyBuilders;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bUnmarshalException;
import com.avob.openadr.model.oadr20b.oadr.OadrCreatedPartyRegistrationType;
import com.avob.openadr.model.oadr20b.oadr.OadrTransportType;

public class Oadr20bCreatedPartyRegistrationTest {

	private Oadr20bJAXBContext jaxbContext;

	public Oadr20bCreatedPartyRegistrationTest() {
		try {
			jaxbContext = Oadr20bJAXBContext.getInstance();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void unvalidatingMarshalUnmarshalTest() throws DatatypeConfigurationException {

		String requestId = null;
		int responseCode = 200;
		String vtnId = "vtn";
		String venId = "ven";
		OadrCreatedPartyRegistrationType request = Oadr20bEiRegisterPartyBuilders
				.newOadr20bCreatedPartyRegistrationBuilder(requestId, responseCode, venId, vtnId).build();

		boolean assertion = false;
		try {
			jaxbContext.marshalRoot(request, true);
		} catch (Oadr20bMarshalException e) {
			assertion = true;
		}

		assertTrue(assertion);

		File file = new File("src/test/resources/eiregisterparty/unvalidatingOadrCreatedPartyRegistration.xml");
		assertion = false;
		try {
			jaxbContext.unmarshal(file, OadrCreatedPartyRegistrationType.class);
		} catch (Oadr20bUnmarshalException e) {
			assertion = true;
		}
		assertTrue(assertion);

	}

	@Test
	public void unmarshalMarshalValidatingTest() throws Oadr20bUnmarshalException, Oadr20bMarshalException {
		File file = new File("src/test/resources/eiregisterparty/oadrCreatedPartyRegistration.xml");
		OadrCreatedPartyRegistrationType unmarshal = jaxbContext.unmarshal(file,
				OadrCreatedPartyRegistrationType.class);
		assertEquals("REQ_123", unmarshal.getEiResponse().getRequestID());
		assertEquals("200", unmarshal.getEiResponse().getResponseCode());
		assertEquals("OK", unmarshal.getEiResponse().getResponseDescription());
		assertEquals("VTN", unmarshal.getVtnID());

		assertEquals(2, unmarshal.getOadrProfiles().getOadrProfile().size());
		assertEquals("2.0a", unmarshal.getOadrProfiles().getOadrProfile().get(0).getOadrProfileName());
		assertEquals(1,
				unmarshal.getOadrProfiles().getOadrProfile().get(0).getOadrTransports().getOadrTransport().size());
		assertEquals(OadrTransportType.SIMPLE_HTTP, unmarshal.getOadrProfiles().getOadrProfile().get(0)
				.getOadrTransports().getOadrTransport().get(0).getOadrTransportName());
		assertEquals("2.0b", unmarshal.getOadrProfiles().getOadrProfile().get(1).getOadrProfileName());
		assertEquals(2,
				unmarshal.getOadrProfiles().getOadrProfile().get(1).getOadrTransports().getOadrTransport().size());
		assertEquals(OadrTransportType.SIMPLE_HTTP, unmarshal.getOadrProfiles().getOadrProfile().get(1)
				.getOadrTransports().getOadrTransport().get(0).getOadrTransportName());
		assertEquals(OadrTransportType.XMPP, unmarshal.getOadrProfiles().getOadrProfile().get(1).getOadrTransports()
				.getOadrTransport().get(1).getOadrTransportName());

		assertEquals(1, unmarshal.getOadrExtensions().getOadrExtension().size());
		assertEquals("My Extension", unmarshal.getOadrExtensions().getOadrExtension().get(0).getOadrExtensionName());
		assertEquals(1, unmarshal.getOadrExtensions().getOadrExtension().get(0).getOadrInfo().size());
		assertEquals("A Key",
				unmarshal.getOadrExtensions().getOadrExtension().get(0).getOadrInfo().get(0).getOadrKey());
		assertEquals("A Value",
				unmarshal.getOadrExtensions().getOadrExtension().get(0).getOadrInfo().get(0).getOadrValue());

		File file2 = new File("src/test/resources/eiregisterparty/genOadrCreatePartyRegistration.xml");
		jaxbContext.marshal(Oadr20bFactory.createOadrCreatedPartyRegistration(unmarshal), file2);
		assertTrue(file2.exists());
		file2.delete();

	}

}
