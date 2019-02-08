package com.avob.openadr.server.oadr20b.vtn.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avob.openadr.client.http.OadrHttpClient;
import com.avob.openadr.client.http.OadrHttpClientBuilder;
import com.avob.openadr.client.http.oadr20b.OadrHttpClient20b;
import com.avob.openadr.client.http.oadr20b.ven.OadrHttpVenClient20b;
import com.avob.openadr.model.oadr20b.Oadr20bSecurity;
import com.avob.openadr.model.oadr20b.builders.Oadr20bEiEventBuilders;
import com.avob.openadr.model.oadr20b.errorcodes.Oadr20bApplicationLayerErrorCode;
import com.avob.openadr.model.oadr20b.exception.Oadr20bException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bHttpLayerException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bXMLSignatureValidationException;
import com.avob.openadr.model.oadr20b.oadr.OadrDistributeEventType;
import com.avob.openadr.model.oadr20b.oadr.OadrRequestEventType;
import com.avob.openadr.security.exception.OadrSecurityException;
import com.avob.openadr.server.common.vtn.models.demandresponseevent.DemandResponseEventDto;
import com.avob.openadr.server.common.vtn.models.demandresponseevent.DemandResponseEventSimpleValueEnum;
import com.avob.openadr.server.common.vtn.models.demandresponseevent.DemandResponseEventStateEnum;
import com.avob.openadr.server.common.vtn.models.user.OadrUser;
import com.avob.openadr.server.common.vtn.models.ven.Ven;
import com.avob.openadr.server.common.vtn.models.venmarketcontext.VenMarketContext;
import com.avob.openadr.server.common.vtn.models.venmarketcontext.VenMarketContextDto;
import com.avob.openadr.server.common.vtn.service.DemandResponseEventService;
import com.avob.openadr.server.common.vtn.service.OadrUserService;
import com.avob.openadr.server.common.vtn.service.VenMarketContextService;
import com.avob.openadr.server.common.vtn.service.VenService;
import com.avob.openadr.server.oadr20b.vtn.VTN20bSecurityApplicationTest;
import com.avob.openadr.server.oadr20b.vtn.service.push.Oadr20bPushService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { VTN20bSecurityApplicationTest.class })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Oadr20bVTNSecurityTest {

	@Value("${oadr.security.vtn.trustcertificate.oadrRsaRootCertificate}")
	private String oadrRsaRootCertificate;

	@Value("${oadr.security.vtn.trustcertificate.oadrRsaIntermediateCertificate}")
	private String oadrRsaIntermediateCertificate;

	@Value("${oadr.security.vtn.trustcertificate.oadrEccRootCertificate}")
	private String oadrEccRootCertificate;

	@Value("${oadr.security.vtn.trustcertificate.oadrEccIntermediateCertificate}")
	private String oadrEccIntermediateCertificate;

	@Value("${oadr.security.ven.rsaPrivateKeyPath}")
	private String rsaPrivateKeyPemFilePath;

	@Value("${oadr.security.ven.rsaCertificatePath}")
	private String rsaClientCertPemFilePath;

	@Value("${oadr.security.ven.eccPrivateKeyPath}")
	private String eccPrivateKeyPemFilePath;

	@Value("${oadr.security.ven.eccCertificatePath}")
	private String eccClientCertPemFilePath;

	@Value("${oadr.server.port}")
	private String port;

	private static final String MARKET_CONTEXT_NAME = "http://security-oadr.avob.com";

	@Resource
	private VenService venService;

	@Resource
	private VenMarketContextService venMarketContextService;

	@Resource
	private OadrUserService oadrUserService;

	@Resource
	private DemandResponseEventService demandResponseEventService;

	@Resource
	private Oadr20bPushService oadr20bDemandResponseEventPushService;

	private String eiEventEndpointUrl = null;

	private String demandResponseEnpointUrl = null;

	@PostConstruct
	public void init() {
		eiEventEndpointUrl = "https://localhost:" + port + "/testvtn";
		demandResponseEnpointUrl = "https://localhost:" + port + "/testvtn/DemandResponseEvent/";
	}

	private void genericTest(OadrHttpVenClient20b client, Ven ven) throws Oadr20bException, Oadr20bHttpLayerException,
			Oadr20bXMLSignatureException, Oadr20bXMLSignatureValidationException {

		// valid request
		OadrRequestEventType event = Oadr20bEiEventBuilders.newOadrRequestEventBuilder(ven.getUsername(), "0").build();
		OadrDistributeEventType OadrRequestEventType = client.oadrRequestEvent(event);
		assertEquals(String.valueOf(HttpStatus.OK_200), OadrRequestEventType.getEiResponse().getResponseCode());
		assertEquals(0, OadrRequestEventType.getOadrEvent().size());

		// mismatch request venId and username
		event = Oadr20bEiEventBuilders.newOadrRequestEventBuilder(ven.getUsername() + "2", "0").build();
		OadrRequestEventType = client.oadrRequestEvent(event);
		assertEquals(String.valueOf(Oadr20bApplicationLayerErrorCode.TARGET_MISMATCH_462),
				OadrRequestEventType.getEiResponse().getResponseCode());
		assertEquals(0, OadrRequestEventType.getOadrEvent().size());

	}

	@Test
	public void testX509() throws Oadr20bException, OadrSecurityException, JAXBException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, URISyntaxException, Oadr20bHttpLayerException,
			Oadr20bXMLSignatureException, Oadr20bXMLSignatureValidationException {

		String[] allCerts = { oadrRsaRootCertificate, oadrRsaIntermediateCertificate };

		// using rsa oadr20a certificate fingerprint as Ven username grant
		// access

		OadrHttpClientBuilder builder = new OadrHttpClientBuilder().withDefaultHost(eiEventEndpointUrl)
				.withTrustedCertificate(Arrays.asList(allCerts))
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers())
				.withX509Authentication(rsaPrivateKeyPemFilePath, rsaClientCertPemFilePath);

		OadrHttpVenClient20b x509HttpClient = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build()));

		String username = "2E:55:12:81:B9:EE:9C:46:72:1D";
		Ven ven = venService.prepare(username);
		ven.setRegistrationId(username);
		venService.save(ven);
		genericTest(x509HttpClient, ven);
		venService.delete(ven);

		// using ecc oadr20a certificate fingerprint as Ven username grant
		// access

		builder = new OadrHttpClientBuilder().withDefaultHost(eiEventEndpointUrl)
				.withTrustedCertificate(Arrays.asList(allCerts))
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers())
				.withX509Authentication(eccPrivateKeyPemFilePath, eccClientCertPemFilePath);

		x509HttpClient = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build()));

		username = "15:97:7B:DE:1C:1F:C6:D2:64:84";
		ven = venService.prepare(username);
		ven.setRegistrationId(username);
		venService.save(ven);
		genericTest(x509HttpClient, ven);
		venService.delete(ven);
	}

	@Test
	public void testDigest() throws Oadr20bException, OadrSecurityException, JAXBException, Oadr20bHttpLayerException,
			Oadr20bXMLSignatureException, Oadr20bXMLSignatureValidationException {

		String[] allCerts = { oadrRsaRootCertificate, oadrRsaIntermediateCertificate };

		String username = "securityVen1";
		String password = "securityVen1";
		String realm = "";
		String nonce = "";

		OadrHttpClientBuilder builder = new OadrHttpClientBuilder().withDefaultHost(eiEventEndpointUrl)
				.withTrustedCertificate(Arrays.asList(allCerts))
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers())
				.withDefaultDigestAuthentication(eiEventEndpointUrl, realm, nonce, username, password);

		OadrHttpVenClient20b digestHttpClient = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build()));

		Ven ven = venService.prepare(username, password);
		ven.setRegistrationId(username);
		venService.save(ven);
		genericTest(digestHttpClient, ven);
		venService.delete(ven);

	}

	@Test
	public void testBasic() throws Oadr20bException, OadrSecurityException, JAXBException, ClientProtocolException,
			IOException, URISyntaxException, Oadr20bHttpLayerException, Oadr20bXMLSignatureException,
			Oadr20bXMLSignatureValidationException {

		String[] allCerts = { oadrRsaRootCertificate, oadrRsaIntermediateCertificate };

		String venUsername = "securityVen1";
		String venPassword = "securityVen1";

		OadrHttpClientBuilder builder = new OadrHttpClientBuilder().withDefaultHost(eiEventEndpointUrl)
				.withTrustedCertificate(Arrays.asList(allCerts))
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers())
				.withDefaultBasicAuthentication(eiEventEndpointUrl, venUsername, venPassword);

		OadrHttpVenClient20b venBasicHttpClient = new OadrHttpVenClient20b(new OadrHttpClient20b(builder.build()));

		VenMarketContext marketContext = venMarketContextService.prepare(new VenMarketContextDto(MARKET_CONTEXT_NAME));
		venMarketContextService.save(marketContext);

		Ven ven = venService.prepare(venUsername, venPassword);
		ven.setVenMarketContexts(Sets.newHashSet(marketContext));
		ven.setPushUrl("http://localhost");
		ven.setRegistrationId(venUsername);
		venService.save(ven);

		genericTest(venBasicHttpClient, ven);

		String venUsername2 = "securityVen2";
		String venPassword2 = "securityVen2";
		Ven ven2 = venService.prepare(venUsername2, venPassword2);
		ven2.setVenMarketContexts(Sets.newHashSet(marketContext));
		ven2.setPushUrl("http://localhost");
		ven2.setRegistrationId(venUsername2);
		venService.save(ven2);

		String userUsername = "securityUser1";
		String userPassword = "securityUser1";

		OadrUser user = oadrUserService.prepare(userUsername, userPassword);
		oadrUserService.save(user);

		OadrHttpClient userBasicHttpClient = new OadrHttpClientBuilder()
				.withDefaultBasicAuthentication(demandResponseEnpointUrl, userUsername, userPassword)
				.withProtocol(Oadr20bSecurity.getProtocols(), Oadr20bSecurity.getCiphers())
				.withTrustedCertificate(Arrays.asList(allCerts))
				.withHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();

		ObjectMapper mapper = new ObjectMapper();
		DemandResponseEventDto dto = new DemandResponseEventDto();
		dto.setEventId("eventId");
		dto.setComaSeparatedTargetedVenUsername(String.join(",", venUsername, venUsername2));
		dto.setDuration("PT1H");
		dto.setNotificationDuration("P1D");
		dto.setToleranceDuration("PT5M");
		dto.setStart(System.currentTimeMillis());
		dto.setState(DemandResponseEventStateEnum.ACTIVE);
		dto.setValue(DemandResponseEventSimpleValueEnum.SIMPLE_SIGNAL_PAYLOAD_HIGH);
		dto.setMarketContext(MARKET_CONTEXT_NAME);

		String payload = mapper.writeValueAsString(dto);
		HttpPost post = new HttpPost(demandResponseEnpointUrl);
		StringEntity stringEntity = new StringEntity(payload);
		post.setEntity(stringEntity);

		HttpResponse execute = userBasicHttpClient.execute(post, "");
		assertEquals(HttpStatus.CREATED_201, execute.getStatusLine().getStatusCode());

		dto = mapper.readValue(execute.getEntity().getContent(), DemandResponseEventDto.class);
		assertNotNull(dto.getId());

		OadrRequestEventType event = Oadr20bEiEventBuilders.newOadrRequestEventBuilder(ven.getUsername(), "0").build();
		OadrDistributeEventType OadrRequestEventType = venBasicHttpClient.oadrRequestEvent(event);
		assertEquals(String.valueOf(HttpStatus.OK_200), OadrRequestEventType.getEiResponse().getResponseCode());
		assertEquals(1, OadrRequestEventType.getOadrEvent().size());

		demandResponseEventService.delete(dto.getId());

		venService.delete(ven);
		venService.delete(ven2);

		venMarketContextService.delete(marketContext);

	}
}
