package com.nttdata.venta.events;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Event <T>{
  private String id;
  private Date date;
  private EvenType type;
  private T data;
}
