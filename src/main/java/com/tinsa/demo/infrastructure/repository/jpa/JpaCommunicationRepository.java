package com.tinsa.demo.infrastructure.repository.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tinsa.demo.domain.model.Communication;
import com.tinsa.demo.domain.ports.secondary.CommunicationRepository;

@Component
@Transactional
public class JpaCommunicationRepository implements CommunicationRepository {

	@Autowired
	private SpringCrudCommunicationRepository crudRepository;

	@Override
	public void save(Communication communication) {

		com.tinsa.demo.infrastructure.repository.jpa.Communication repoCommunication = crudRepository
				.findByDestinatarioAndTipoEnvio(communication.getDestinatario(), communication.getTipoEnvio());
		if (repoCommunication == null) {
			repoCommunication = new com.tinsa.demo.infrastructure.repository.jpa.Communication(
					communication.getDestinatario(), communication.getMensaje(), communication.getEstado(),
					communication.getTipoEnvio());
			crudRepository.save(repoCommunication);
		} else {
			repoCommunication.setMensaje(communication.getMensaje());
			repoCommunication.setEstado(communication.getEstado());
		}
	}

	@Override
	public boolean exist(String destinatario, String tipoEnvio) {
		return crudRepository.findByDestinatarioAndTipoEnvio(destinatario, tipoEnvio)!=null;
	}
}
