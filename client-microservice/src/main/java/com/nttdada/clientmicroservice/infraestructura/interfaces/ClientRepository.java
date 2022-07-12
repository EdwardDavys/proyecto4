package com.nttdada.clientmicroservice.infraestructura.interfaces;

import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    Flux<ClientDTO> getAll();
    Mono<ClientDTO> save(Mono<ClientDTO> clientDTOMono);
    Mono<ClientDTO> getClient(String idClient);
    Mono<Client> existsById(String idClient);
    Mono<ClientDTO> updateClient(Mono<ClientDTO> clientDTOMono, String idClient);

    Mono<Void> deleteClient(String idClient);

    Mono<Client> findByNameClient(String name);
}
