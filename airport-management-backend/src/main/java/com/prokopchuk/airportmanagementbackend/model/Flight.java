package com.prokopchuk.airportmanagementbackend.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Flight {

  private Long id;
  private String departureFrom;
  private String destination;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;

}
