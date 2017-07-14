package com.tinsa.demo.domain.ports.secondary;

import com.tinsa.demo.domain.model.NotificationResult;

public interface NotifierRepository 
{
	NotificationResult sendNotification(String recipient, String message);
}
