package com.nttdata.pedido.service;

import com.nttdata.pedido.entity.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  private final PedidoEventsService pedidoEventsService;


  public PedidoService(PedidoEventsService pedidoEventsService) {
    super();
    this.pedidoEventsService = pedidoEventsService;
  }

  public Pedido save(Pedido pedido){
    System.out.println("Recibido " + pedido);
    this.pedidoEventsService.publish(pedido);
    return pedido;
  }
}
