package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class Flight extends Trip {
  public String flightNumber;
}
