package com.avob.openadr.server.common.vtn;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.SocketUtils;

import com.avob.openadr.security.OadrHttpSecurity;
import com.avob.openadr.security.exception.OadrSecurityException;
import com.avob.openadr.server.common.vtn.exception.OadrVTNInitializationException;
import com.google.common.collect.Maps;

@Configuration
public class VtnConfig {

	public static final String CONTEXT_PATH_CONF = "oadr.server.context_path";
	public static final String PORT_CONF = "oadr.server.port";
	public static final String TRUSTED_CERTIFICATES_CONF = "oadr.security.ven.trustcertificate";
	public static final String PRIVATE_KEY_CONF = "oadr.security.vtn.key";
	public static final String CERTIFICATE_CONF = "oadr.security.vtn.cert";
	public static final String SUPPORT_PUSH_CONF = "oadr.supportPush";
	public static final String SUPPORT_UNSECURED_PHTTP_PUSH_CONF = "oadr.supportUnsecuredHttpPush";
	public static final String PULL_FREQUENCY_SECONDS_CONF = "oadr.pullFrequencySeconds";
	public static final String HOST_CONF = "oadr.server.host";
	public static final String VALIDATE_OADR_PAYLOAD_XSD_CONF = "oadr.validateOadrPayloadAgainstXsd";
	public static final String VTN_ID_CONF = "oadr.vtnid";
	public static final String SAVE_VEN_UPDATE_REPORT_CONF = "oadr.saveVenData";
	public static final String REPLAY_PROTECTACCEPTED_DELAY_SECONDS_CONF = "oadr.security.replayProtectAcceptedDelaySecond";
	public static final String CA_KEY_CONF = "oadr.security.ca.key";
	public static final String CA_CERT_CONF = "oadr.security.ca.cert";

	public static final String BROKER_USER_CONF = "oadr.broker.user";
	public static final String BROKER_PASS_CONF = "oadr.broker.password";
	public static final String BROKER_PORT_CONF = "oadr.broker.port";
	public static final String BROKER_HOST_CONF = "oadr.broker.host";

	public static final String BROKER_SSL_HOST_CONF = "oadr.broker.ssl.host";
	public static final String BROKER_SSL_PORT_CONF = "oadr.broker.ssl.port";

	@Value("${" + CONTEXT_PATH_CONF + ":#{null}}")
	private String contextPath;

	@Value("${" + PORT_CONF + ":#{8443}}")
	private int port;

	@Value("${" + TRUSTED_CERTIFICATES_CONF + ":#{null}}")
	private String trustCertificatesStr;

	private List<String> trustCertificates = null;

	@Value("${" + PRIVATE_KEY_CONF + ":#{null}}")
	private String key;

	@Value("${" + CERTIFICATE_CONF + ":#{null}}")
	private String cert;

	@Value("${" + SUPPORT_PUSH_CONF + ":#{null}}")
	private Boolean supportPush;

	@Value("${" + SUPPORT_UNSECURED_PHTTP_PUSH_CONF + ":#{false}}")
	private Boolean supportUnsecuredHttpPush;

	@Value("${" + PULL_FREQUENCY_SECONDS_CONF + ":#{null}}")
	private Long pullFrequencySeconds;

	@Value("${" + HOST_CONF + ":localhost}")
	private String host;

	@Value("${" + VALIDATE_OADR_PAYLOAD_XSD_CONF + ":false}")
	private Boolean validateOadrPayloadAgainstXsd;

	@Value("${" + VTN_ID_CONF + ":#{null}}")
	private String vtnId;

	@Value("${" + SAVE_VEN_UPDATE_REPORT_CONF + ":#{false}}")
	private Boolean saveVenData;

	@Value("${" + REPLAY_PROTECTACCEPTED_DELAY_SECONDS_CONF + ":#{1200}}")
	private Long replayProtectAcceptedDelaySecond;

	@Value("${" + CA_KEY_CONF + ":#{null}}")
	private String caKey;

	@Value("${" + CA_CERT_CONF + ":#{null}}")
	private String caCert;

	@Value("${" + BROKER_HOST_CONF + ":localhost}")
	private String brokerHost;

	@Value("${" + BROKER_PORT_CONF + ":#{null}}")
	private Integer brokerPort;

	@Value("${" + BROKER_USER_CONF + ":#{null}}")
	private String brokerUser;

	@Value("${" + BROKER_PASS_CONF + ":#{null}}")
	private String brokerPass;

	@Value("${" + BROKER_SSL_PORT_CONF + ":#{null}}")
	private Integer brokerSslPort;

	@Value("${" + BROKER_SSL_HOST_CONF + ":localhost}")
	private String brokerSslHost;

	@Autowired
	private ConfigurableEnvironment env;

	private KeyManagerFactory keyManagerFactory;
	private TrustManagerFactory trustManagerFactory;
	private String oadr20bFingerprint;
	private String brokerUrl;
	private String sslBrokerUrl;

	@PostConstruct
	public void init() {

		if (trustCertificatesStr != null) {
			trustCertificates = Arrays.asList(trustCertificatesStr.split(","));
		} else {
			trustCertificates = new ArrayList<>();
		}
		Map<String, String> trustedCertificates = Maps.newHashMap();
		int i = 0;
		for (String path : trustCertificates) {
			trustedCertificates.put("cert_" + (i++), path);
		}

		if (this.getCert() != null) {
			String keystorePassword = UUID.randomUUID().toString();

			KeyStore keystore;
			try {
				oadr20bFingerprint = OadrHttpSecurity.getOadr20bFingerprint(this.getCert());

				keystore = OadrHttpSecurity.createKeyStore(this.getKey(), this.getCert(), keystorePassword);
				KeyStore truststore = OadrHttpSecurity.createTrustStore(trustedCertificates);

				// init key manager factory
				KeyStore createKeyStore = keystore;
				setKeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
				getKeyManagerFactory().init(createKeyStore, keystorePassword.toCharArray());

				// init trust manager factory
				setTrustManagerFactory(TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()));
				getTrustManagerFactory().init(truststore);
				// init ssl context
			} catch (KeyStoreException e) {
				throw new OadrVTNInitializationException(e);
			} catch (NoSuchAlgorithmException e) {
				throw new OadrVTNInitializationException(e);
			} catch (CertificateException e) {
				throw new OadrVTNInitializationException(e);
			} catch (IOException e) {
				throw new OadrVTNInitializationException(e);
			} catch (OadrSecurityException e) {
				throw new OadrVTNInitializationException(e);
			} catch (UnrecoverableKeyException e) {
				throw new OadrVTNInitializationException(e);
			}
		}

		if (getBrokerPort() == null) {
			setBrokerPort(SocketUtils.findAvailableTcpPort());
		}

		if (brokerSslPort == null) {
			brokerSslPort = SocketUtils.findAvailableTcpPort();
		}
		setBrokerUrl("tcp://" + getBrokerHost() + ":" + getBrokerPort());
		setSslBrokerUrl("ssl://" + brokerSslHost + ":" + brokerSslPort);

	}

	public boolean hasExternalRabbitMQBroker() {
		List<String> profiles = Arrays.asList(env.getActiveProfiles());
		return profiles.contains("rabbitmq-broker") || profiles.contains("external");
	}

	public boolean hasInMemoryBroker() {
		return !this.hasExternalRabbitMQBroker();
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List<String> getTrustCertificates() {
		return trustCertificates;
	}

	public void setTrustCertificates(List<String> trustCertificates) {
		this.trustCertificates = trustCertificates;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public Boolean getSupportPush() {
		return supportPush;
	}

	public void setSupportPush(Boolean supportPush) {
		this.supportPush = supportPush;
	}

	public Boolean getSupportUnsecuredHttpPush() {
		return supportUnsecuredHttpPush;
	}

	public void setSupportUnsecuredHttpPush(Boolean supportUnsecuredHttpPush) {
		this.supportUnsecuredHttpPush = supportUnsecuredHttpPush;
	}

	public Long getPullFrequencySeconds() {
		return pullFrequencySeconds;
	}

	public void setPullFrequencySeconds(Long pullFrequencySeconds) {
		this.pullFrequencySeconds = pullFrequencySeconds;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Boolean getValidateOadrPayloadAgainstXsd() {
		return validateOadrPayloadAgainstXsd;
	}

	public void setValidateOadrPayloadAgainstXsd(Boolean validateOadrPayloadAgainstXsd) {
		this.validateOadrPayloadAgainstXsd = validateOadrPayloadAgainstXsd;
	}

	public String getVtnId() {
		return vtnId;
	}

	public void setVtnId(String vtnId) {
		this.vtnId = vtnId;
	}

	public Boolean getSaveVenData() {
		return saveVenData;
	}

	public void setSaveVenData(Boolean saveVenData) {
		this.saveVenData = saveVenData;
	}

	public Long getReplayProtectAcceptedDelaySecond() {
		return replayProtectAcceptedDelaySecond;
	}

	public void setReplayProtectAcceptedDelaySecond(Long replayProtectAcceptedDelaySecond) {
		this.replayProtectAcceptedDelaySecond = replayProtectAcceptedDelaySecond;
	}

	public String getCaKey() {
		return caKey;
	}

	public void setCaKey(String ca) {
		this.caKey = ca;
	}

	public String getCaCert() {
		return caCert;
	}

	public void setCaCert(String caPubKey) {
		this.caCert = caPubKey;
	}

	public KeyManagerFactory getKeyManagerFactory() {
		return keyManagerFactory;
	}

	public void setKeyManagerFactory(KeyManagerFactory keyManagerFactory) {
		this.keyManagerFactory = keyManagerFactory;
	}

	public TrustManagerFactory getTrustManagerFactory() {
		return trustManagerFactory;
	}

	public void setTrustManagerFactory(TrustManagerFactory trustManagerFactory) {
		this.trustManagerFactory = trustManagerFactory;
	}

	public String getOadr20bFingerprint() {
		return oadr20bFingerprint;
	}

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public String getSslBrokerUrl() {
		return sslBrokerUrl;
	}

	public void setSslBrokerUrl(String sslBrokerUrl) {
		this.sslBrokerUrl = sslBrokerUrl;
	}

	public String getBrokerUser() {
		return brokerUser;
	}

	public void setBrokerUser(String brokerUser) {
		this.brokerUser = brokerUser;
	}

	public String getBrokerPass() {
		return brokerPass;
	}

	public void setBrokerPass(String brokerPass) {
		this.brokerPass = brokerPass;
	}

	public String getBrokerHost() {
		return brokerHost;
	}

	public void setBrokerHost(String brokerHost) {
		this.brokerHost = brokerHost;
	}

	public Integer getBrokerPort() {
		return brokerPort;
	}

	public void setBrokerPort(Integer brokerPort) {
		this.brokerPort = brokerPort;
	}

}
