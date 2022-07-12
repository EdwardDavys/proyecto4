package com.nttdada.clientmicroservice.infraestructura.repositorios;

//import com.nttdada.clientmicroservice.aplicacion.config.TypeClientFeingClient;
import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
//import com.nttdada.clientmicroservice.dominio.entidades.TypeClientDTO;
import com.nttdada.clientmicroservice.infraestructura.crud.ClientCrudRepository;
import com.nttdada.clientmicroservice.infraestructura.interfaces.ClientRepository;
import com.nttdada.clientmicroservice.infraestructura.mapeo.Mapper;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ClientRepositoryR implements ClientRepository {

   @Autowired
   private ClientCrudRepository clientCrudRepository;

    @Override
    public Flux<ClientDTO> getAll() {

        return clientCrudRepository.findAll().map(Mapper::entityToDto);
    }


    @Override
    public Mono<ClientDTO> save(Mono<ClientDTO> clientDTOMono ) {

        return clientDTOMono.map(Mapper::dtoToEntity)
                .flatMap(clientCrudRepository::save)
                .map(Mapper::entityToDto);

    }

    @Override
    public Mono<ClientDTO> getClient(String idClient) {
        return clientCrudRepository.findById(idClient).map(Mapper::entityToDto);
    }

    @Override
    public Mono<Client> existsById(String idClient) {
        return null;
    }

    @Override
    public Mono<ClientDTO> updateClient(Mono<ClientDTO> clientDTOMono, String idclient) {
        return clientCrudRepository.findById(idclient)
                .flatMap(p->clientDTOMono.map(Mapper::dtoToEntity)
                .doOnNext(e->e.setId(idclient)))
                .flatMap(clientCrudRepository::save)
                .map(Mapper::entityToDto);
    }

    @Override
    public Mono<Void> deleteClient(String idClient) {
        return clientCrudRepository.deleteById(idClient);
    }

  @Override
  public Mono<Client> findByNameClient(String name) {
    return clientCrudRepository.findByNameClient(name);
  }


}
