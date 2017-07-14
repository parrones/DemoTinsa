package com.tinsa.demo.infrastructure.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="clients")
@Table(name="CLIENTS")
public class Client extends Datable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	@NotNull
	private String name;

	@Column(name = "NOTIFICATION_TYPE")
	@NotNull
	private String notificationType;
	
	@Column(name = "RECIPIENT")
	@NotNull
	private String recipient;

	public Client() 
	{
		
	}

	public Client(String name, String notificationType, String recipient) 
	{
		this.name = name;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
