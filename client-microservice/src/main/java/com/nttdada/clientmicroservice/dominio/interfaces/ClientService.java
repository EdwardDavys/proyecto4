package com.nttdada.clientmicroservice.dominio.interfaces;

import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Flux<ClientDTO> getAll();
    Mono<ClientDTO> save(Mono<ClientDTO> clientMono);
    Mono<ClientDTO> getClient(String idClient);
    Mono<ClientDTO> existsById(String idClient);
    Mono<ClientDTO>updateClient(Mono<ClientDTO> clientDTOMono, String idClient);
    Mono<Void> deleteClient(String id);

    Mono<Client> findByNameClient(String name);

}
