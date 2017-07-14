package com.tinsa.demo.infrastructure.entry.rest;

public class CreateNotificationResponse 
{
	private long notificationId;

	public CreateNotificationResponse() 
	{
	}

	public CreateNotificationResponse(long notificationId) {
		this.notificationId = notificationId;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}
}
