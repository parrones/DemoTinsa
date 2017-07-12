package com.tinsa.demo.domain.ports.primary;

import com.tinsa.demo.domain.model.NotificationResult;

public class CreateNotificationResponse 
{
	private NotificationResult notificatioResult;
	
	public void setNotificationResult(NotificationResult operationResult) 
	{
		this.notificatioResult = operationResult;
	}
	
//	public boolean isSuccess()
//	{
//		return this.notificatioResult == NotificationResult.OK;
//	}

	public NotificationResult getNotificatioResult() 
	{
		return notificatioResult;
	}
}
