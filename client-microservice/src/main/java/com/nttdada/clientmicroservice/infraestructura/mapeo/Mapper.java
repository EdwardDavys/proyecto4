package com.nttdada.clientmicroservice.infraestructura.mapeo;

import com.nttdada.clientmicroservice.dominio.entidades.ClientDTO;
import com.nttdada.clientmicroservice.infraestructura.model.document.Client;
import org.springframework.beans.BeanUtils;

public class Mapper {

    public static ClientDTO entityToDto(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }
    public static Client dtoToEntity(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return client;
    }



}
