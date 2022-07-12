package com.nttdata.pedido.events;

import com.nttdata.pedido.entity.Pedido;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class PedidoCreatedEvent extends Event<Pedido>{

}
