package com.prokopchuk.airportmanagementbackend.common.dto.crewmember;

import com.prokopchuk.airportmanagementbackend.common.dto.flight.FlightDto;
import com.prokopchuk.airportmanagementbackend.model.Position;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrewMemberDto {

  private Long id;
  private String name;
  private String surname;
  private Position position;
  private List<FlightDto> flights;

}
