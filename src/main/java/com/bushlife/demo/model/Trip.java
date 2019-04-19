package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({

    @JsonSubTypes.Type(value = Flight.class, name = "Flight")

})
public class Trip extends Thing {
  public List<Thing> hasPart;
}
