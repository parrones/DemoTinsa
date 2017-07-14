package com.tinsa.demo.infrastructure.repository.jpa;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.ports.secondary.ClientRepository;

@Component
@Transactional
public class JpaClientRepository implements ClientRepository {
	@Autowired
	SpringCrudClientRepository crudRepository;

	@Override
	public long save(com.tinsa.demo.domain.model.Client client) {
		Client repoClient = crudRepository.findByNameAndNotificationType(client.getName(), client.getNotificationType());
		if (repoClient == null) {
			repoClient = new Client(client.getName(), client.getNotificationType(), client.getRecipient());
			return crudRepository.save(repoClient).getId();
		} else {
			repoClient.setRecipient(client.getRecipient());
			return repoClient.getId();
		}
	}

	@Override
	public boolean exist(String name, String notificationType) {
		return crudRepository.findByNameAndNotificationType(name, notificationType) != null;
	}

	@Override
	public Optional<com.tinsa.demo.domain.model.Client> findByClientId(long clientId) {
		
		Client repoClient = crudRepository.findOne(clientId);
		if (repoClient == null) {
			return Optional.empty();
		}

		return Optional.of(new com.tinsa.demo.domain.model.Client(repoClient.getName(), repoClient.getNotificationType(),
				repoClient.getRecipient()));
	}
}
