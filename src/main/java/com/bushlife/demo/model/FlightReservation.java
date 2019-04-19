package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class FlightReservation extends Reservation {

  public List<Trip> reservationFor;
  public List<Ticket> ticket;
}
