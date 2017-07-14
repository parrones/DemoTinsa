package com.tinsa.demo.infrastructure.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "notifications")
@Table(name = "NOTIFICATIONS")
public class Notification extends Datable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "MESSAGE")
	@NotNull
	private String message;

	@Column(name = "STATUS")
	@NotNull
	private String status;

	@Column(name = "CLIENT_ID")
	@NotNull
	private long clientId;

	public Notification() 
	{
	}

	public Notification(String message, String status, long clientId) 
	{
		this.message = message;
		this.status = status;
		this.clientId = clientId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
}
