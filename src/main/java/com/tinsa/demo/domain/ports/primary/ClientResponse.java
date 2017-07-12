package com.tinsa.demo.domain.ports.primary;

public class ClientResponse 
{
	private long clientId;

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	public boolean isSuccess()
	{
		return clientId > 0;
	}
}
