package com.nttdada.clientmicroservice.aplicacion.api;


import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
import com.nttdada.clientmicroservice.dominio.servicios.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Este es la clase controladora de Clients.
 *
 *
 */
@RestController
@RequestMapping("/clients")
public class ClientControlller {
  @Autowired
  private ClientServiceImpl clientService;

  @GetMapping
  public Flux<ClientDTO> getClients(){

    return clientService.getAll();
  }

  @GetMapping("/{idClient}")
  public Mono<ClientDTO> getClient(@PathVariable String idClient){
    return clientService.getClient(idClient);
  }

  @PostMapping
  public Mono<ClientDTO> saveClient(@RequestBody Mono<ClientDTO> clientDTO){
    return clientService.save(clientDTO);
  }

  @PutMapping("/{idClient}")
  public Mono<ClientDTO> updateClient(@RequestBody Mono<ClientDTO> clientDTOMono , @PathVariable String idClient){
    return clientService.updateClient(clientDTOMono,idClient);
  }

  @DeleteMapping("/{idClient}")
  public Mono<Void> deleteClient(@PathVariable String idClient){
    return clientService.deleteClient(idClient);
  }
}
