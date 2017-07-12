package com.tinsa.demo.infrastructure.repository.rest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.tinsa.demo.domain.model.NotificationResult;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FaxNotificationWsRepositoryIT 
{
	private static final String DEFAULT_PORT = "8085";
	private static final String PHONE = "911234567";
	private static final String MESSAGE = "message";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE;
	private static int port = Integer.parseInt(DEFAULT_PORT);
	
	@ClassRule
	public static WireMockClassRule wireMockRule = new WireMockClassRule(port);
	@Rule
	public WireMockClassRule instanceRule = wireMockRule;
	
	@Autowired
	private FaxNotificationWsRepository notificationRepository;
	
	@Before
	  public void setUp()
	  {
		notificationRepository.setFaxNotificationServiceUrl("http://localhost:" + port + "/tinsa/fax");
	  }
	
	@AfterClass
	  public static void stopWireMock() 
	{
	    wireMockRule.stop();
	}
	
	@Test
	public void sendNotification()
	{
		 stubFor(get(urlEqualTo("/tinsa/fax?phone=" + PHONE + "&message=" + MESSAGE))
			            .willReturn(aResponse().withStatus(200).withHeader(CONTENT_TYPE, CONTENT_TYPE_JSON)
			                .withBody(jsonStatus())));
		 
		 NotificationResult result = notificationRepository.sendNotification(PHONE, MESSAGE);
		 
		 assertThat(result, Matchers.is(NotificationResult.OK));
	}
	
	@Test
	public void sendNotificationError()
	{
		 stubFor(get(urlEqualTo("/tinsa/fax?phone=" + PHONE + "&message=" + MESSAGE))
			            .willReturn(aResponse().withStatus(500)));
		 
		 NotificationResult result = notificationRepository.sendNotification(PHONE, MESSAGE);
		 
		 assertThat(result, Matchers.is(NotificationResult.KO));
	}

	private String jsonStatus()
	{
		return "{\"status\": \"ok\"}";
	}
}
