package com.tinsa.demo.infrastructure.repository.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tinsa.demo.domain.model.Notification;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class JpaNotificationRepositoryIT 
{
	private static final String STATUS_KO = "KO";
	private static final String STATUS_OK = "OK";
	private static final String MESSAGE = "message";
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Test
	public void saveOKNotifications()
	{
		Notification notification = new Notification(MESSAGE, 1l, STATUS_OK);
		
		assertFalse(notificationRepository.exist(MESSAGE, STATUS_OK, 1l));
		
		notificationRepository.save(notification);
		
		assertTrue(notificationRepository.exist(MESSAGE, STATUS_OK, 1l));
	}
	
	@Test
	public void saveKONotifications()
	{
		Notification notification = new Notification(MESSAGE, 2l, STATUS_KO);
		
		assertFalse(notificationRepository.exist(MESSAGE, STATUS_KO, 2l));
		
		notificationRepository.save(notification);
		
		assertTrue(notificationRepository.exist(MESSAGE, STATUS_KO, 2l));
	}
}
