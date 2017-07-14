package com.tinsa.demo.infrastructure.repository.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import com.tinsa.demo.domain.model.NotificationResult;
import com.tinsa.demo.domain.ports.secondary.NotifierRepository;

@Component
public class SmsNotifierWsRepository implements NotifierRepository{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsNotifierWsRepository.class);
	private String smsUrl = "http://localhost:9100/tinsa/sms";

	public void setSmsNotificationServiceUrl(String url)
	{
		smsUrl = url;
	}

	@Override
	public NotificationResult sendNotification(String recipient, String message) 
	{
		try
		{
			RestTemplate restTemplate = new RestTemplate();
			String urlBuilt
			  = smsUrl.concat("?phone={recipient}&message={message}");
			
			restTemplate.getForObject(urlBuilt, String.class, recipient, message);
			
			return NotificationResult.OK;
		}
		catch(RestClientException e)
		{
			LOGGER.info("Error in SmsNotificationWsRepository - recipient: {} -  message: {} - {}", recipient, message, e.getMessage());
			return NotificationResult.KO;
		}
	}
}
