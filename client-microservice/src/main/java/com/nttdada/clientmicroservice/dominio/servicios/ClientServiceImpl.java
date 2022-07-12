package com.nttdada.clientmicroservice.dominio.servicios;

import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
import com.nttdada.clientmicroservice.dominio.interfaces.ClientService;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import com.nttdada.clientmicroservice.infraestructura.repositorios.ClientRepositoryR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepositoryR  clientRepositoryR;

    @Override
    public Flux<ClientDTO> getAll() {
        return clientRepositoryR.getAll();
    }

    @Override
    public Mono<ClientDTO> save(Mono<ClientDTO> clientMono) {
        return clientRepositoryR.save(clientMono);
    }

    @Override
    public Mono<ClientDTO> getClient(String idClient) {
        return clientRepositoryR.getClient(idClient);
    }

    @Override
    public Mono<ClientDTO> existsById(String idClient) {
        return /*clientRepositoryR.existsById(idClient)*/null;
    }

    @Override
    public Mono<ClientDTO> updateClient(Mono<ClientDTO> clientDTOMono, String idClient) {
        return clientRepositoryR.updateClient(clientDTOMono,idClient);
    }

    @Override
    public Mono<Void> deleteClient(String id) {
        return clientRepositoryR.deleteClient(id);
    }

    @Override
    public Mono<Client> findByNameClient(String name) {
        return clientRepositoryR.findByNameClient(name);
    }
}
