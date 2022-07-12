package com.nttdata.venta.entity;

import lombok.Data;

@Data
public class Pedido {

  private Long id;
  private String name;
  private Double price;
  private String amount;
}
