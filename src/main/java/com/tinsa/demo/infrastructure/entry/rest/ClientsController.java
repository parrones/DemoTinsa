package com.tinsa.demo.infrastructure.entry.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tinsa.demo.domain.model.NotificationResult;
import com.tinsa.demo.domain.ports.primary.CreateClientUseCase;
import com.tinsa.demo.domain.ports.primary.CreateNotificationUseCase;

@RestController
@RequestMapping("/api")
public class ClientsController {

	@Autowired
	private CreateClientUseCase createClientUseCase;
	@Autowired
	private CreateNotificationUseCase createNotificationUseCase;

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public ResponseEntity<CreateClientResponse> createClient(@Valid @RequestBody CreateClientRequest restRequest) {
		com.tinsa.demo.domain.ports.primary.ClientRequest request = new com.tinsa.demo.domain.ports.primary.ClientRequest(
				restRequest.getName(), restRequest.getNotificationType(), restRequest.getRecipient());
		com.tinsa.demo.domain.ports.primary.ClientResponse response = new com.tinsa.demo.domain.ports.primary.ClientResponse();

		createClientUseCase.execute(request, response);
		if (response.isSuccess()) {
			return new ResponseEntity<CreateClientResponse>(new CreateClientResponse(response.getClientId()),
					HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@RequestMapping(value = "/clients/{clientId}/notifications", method = RequestMethod.POST)
	public ResponseEntity<CreateNotificationResponse> createNotification(@PathVariable("clientId") long clientId,
			@Valid @RequestBody CreateNotificationRequest restRequest) 
	{
		com.tinsa.demo.domain.ports.primary.CreateNotificationRequest request = new com.tinsa.demo.domain.ports.primary.CreateNotificationRequest(
				clientId, restRequest.getMessage());
		com.tinsa.demo.domain.ports.primary.CreateNotificationResponse response = new com.tinsa.demo.domain.ports.primary.CreateNotificationResponse();

		createNotificationUseCase.execute(request, response);
		
		if(response.getNotificatioResult() == NotificationResult.OK)
		{
			return new ResponseEntity<CreateNotificationResponse>(new CreateNotificationResponse(response.getNotificationId()), HttpStatus.OK);
		}
		else if(response.getNotificatioResult() == NotificationResult.CLIENT_NOT_FOUND)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
