package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface SpringCrudCommunicationRepository extends CrudRepository<Communication, Long>
{
	Communication findByDestinatarioAndTipoEnvio(String destinatario, String tipoEnvio);
}
