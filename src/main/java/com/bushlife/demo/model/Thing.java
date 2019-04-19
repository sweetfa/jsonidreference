package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({

    @JsonSubTypes.Type(value = Ticket.class, name = "Ticket"),
    @JsonSubTypes.Type(value = Trip.class, name = "Trip"),
    @JsonSubTypes.Type(value = Flight.class, name = "Flight"),
    @JsonSubTypes.Type(value = PropertyValue.class, name = "PropertyValue"),
    @JsonSubTypes.Type(value = Reservation.class, name = "Reservation"),
    @JsonSubTypes.Type(value = FlightReservation.class, name = "FlightReservation")

})
public class Thing {

  public List<Thing> subjectOf;
  public List<Thing> identifier;
}
