package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class Ticket extends Thing {

  public String ticketNumber;
}
