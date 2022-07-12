package com.nttdata.venta.events;

import com.nttdata.venta.entity.Pedido;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PedidoCreatedEvent extends Event<Pedido>{
}
