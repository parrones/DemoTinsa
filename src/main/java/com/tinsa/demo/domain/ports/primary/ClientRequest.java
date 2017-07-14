package com.tinsa.demo.domain.ports.primary;

public class ClientRequest 
{
	private String name;
	private String notificationType;
	private String recipient;
	
	public ClientRequest(String name, String notificationType, String recipient) 
	{
		this.name = name;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
