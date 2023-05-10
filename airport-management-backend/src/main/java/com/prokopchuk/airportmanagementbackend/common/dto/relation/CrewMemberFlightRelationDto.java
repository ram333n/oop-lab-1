package com.prokopchuk.airportmanagementbackend.common.dto.relation;

import lombok.Data;

@Data
public class CrewMemberFlightRelationDto {

  private Long crewMemberId;
  private Long flightId;

}
