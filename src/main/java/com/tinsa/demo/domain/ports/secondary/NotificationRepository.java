package com.tinsa.demo.domain.ports.secondary;

import com.tinsa.demo.domain.model.Notification;

public interface NotificationRepository 
{
	long save(Notification notification);
	
	boolean exist(String message, String status, long clientId);
}
