package com.prokopchuk.airportmanagementbackend.common.dto.flight;

import com.prokopchuk.airportmanagementbackend.common.dto.crewmember.CrewMemberDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

  private Long id;
  private String departureFrom;
  private String destination;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
  private List<CrewMemberDto> crewMembers;

}
