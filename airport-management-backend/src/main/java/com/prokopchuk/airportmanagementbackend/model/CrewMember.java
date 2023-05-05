package com.prokopchuk.airportmanagementbackend.model;

import lombok.Data;

@Data
public class CrewMember {

  private Long id;
  private String name;
  private String surname;
  private Position position;

}
