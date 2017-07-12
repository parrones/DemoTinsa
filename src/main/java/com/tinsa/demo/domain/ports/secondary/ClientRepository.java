package com.tinsa.demo.domain.ports.secondary;

import java.util.Optional;

import com.tinsa.demo.domain.model.Client;

public interface ClientRepository 
{
	long save(Client client);
	
	boolean exist(String name, String communication);
	
	Optional<Client> findByClientId(long clientId);
}
