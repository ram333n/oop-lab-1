package com.prokopchuk.airportmanagementbackend.common.dto.crewmember;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prokopchuk.airportmanagementbackend.common.dto.flight.FlightDto;
import com.prokopchuk.airportmanagementbackend.model.Position;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrewMemberDto {

  private Long id;
  private String name;
  private String surname;
  private Position position;
  private List<FlightDto> flights;

  public void createFlightsIfAbsent() {
    if (flights == null) {
      flights = new ArrayList<>();
    }
  }

}
