package com.nttdata.pedido.service;


import com.nttdata.pedido.entity.Pedido;
import com.nttdata.pedido.events.Event;
import com.nttdata.pedido.events.EventType;
import com.nttdata.pedido.events.PedidoCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PedidoEventsService {

  private KafkaTemplate<String, Event<?>> producer;

  @Value("${topic.pedido.name:pedidos}")
  private String topicPedido;

  public void publish(Pedido pedido){
    PedidoCreatedEvent createdEvent = new PedidoCreatedEvent();

    createdEvent.setData(pedido);
    createdEvent.setId(UUID.randomUUID().toString());
    createdEvent.setType(EventType.CREATED);
    createdEvent.setDate(new Date());

    this.producer.send(topicPedido,createdEvent);
  }
}
