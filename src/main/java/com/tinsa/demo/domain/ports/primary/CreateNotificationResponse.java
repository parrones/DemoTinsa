package com.tinsa.demo.domain.ports.primary;

import com.tinsa.demo.domain.model.NotificationResult;

public class CreateNotificationResponse 
{
	private NotificationResult notificatioResult;
	private long notificationId;
	
	public void setNotificationResult(NotificationResult operationResult) 
	{
		this.notificatioResult = operationResult;
	}

	public NotificationResult getNotificatioResult() 
	{
		return notificatioResult;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public void setNotificatioResult(NotificationResult notificatioResult) {
		this.notificatioResult = notificatioResult;
	}
}
