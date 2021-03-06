package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({

    @JsonSubTypes.Type(value = FlightReservation.class, name = "FlightReservation")

})
public class Reservation extends Thing {

  public String reservationId;
}
