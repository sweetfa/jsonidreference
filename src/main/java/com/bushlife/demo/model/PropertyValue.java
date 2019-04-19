package com.bushlife.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class PropertyValue extends Thing {
  public String propertyId;
  public String value;
  public Thing valueReference;
}
