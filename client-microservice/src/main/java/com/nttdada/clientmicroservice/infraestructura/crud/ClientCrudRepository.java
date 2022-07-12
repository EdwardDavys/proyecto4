package com.nttdada.clientmicroservice.infraestructura.crud;

import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface ClientCrudRepository extends ReactiveCrudRepository<Client,String> {

  Mono<Client> findByNameClient(String name);
}
