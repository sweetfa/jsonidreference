package com.bushlife.demo;

import static com.bushlife.demo.JacksonTestDataLoader.readJson;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bushlife.demo.model.FlightReservation;
import org.junit.jupiter.api.Test;

public class LoadTest {

  @Test
  public void testLoad() {
    FlightReservation reservation = readJson(this.getClass(), "example.json", FlightReservation.class);
    assertTrue(reservation.reservationFor.get(0).hasPart.get(0) == reservation.ticket.get(1).subjectOf.get(0));
    assertTrue(reservation.reservationFor.get(0).hasPart.get(1) == reservation.ticket.get(0).subjectOf.get(0));
  }
}
