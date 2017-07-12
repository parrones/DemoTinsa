package com.tinsa.demo.domain.ports.secondary;

import com.tinsa.demo.domain.model.Communication;

public interface CommunicationRepository 
{
	void save(Communication communication);
	
	boolean exist(String destinatario, String tipoEnvio);
}
