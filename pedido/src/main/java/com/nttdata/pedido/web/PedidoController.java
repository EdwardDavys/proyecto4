package com.nttdata.pedido.web;


import com.nttdata.pedido.entity.Pedido;
import com.nttdata.pedido.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;

  public PedidoController(PedidoService pedidoService) {
    super();
    this.pedidoService = pedidoService;
  }

  @PostMapping
  public Pedido save(@RequestBody Pedido pedido){
    return this.pedidoService.save(pedido);
  }
}
