package com.prokopchuk.airportmanagementbackend.common.dto.crewmember;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CrewMemberListDto {

  private List<CrewMemberDto> crewMembers;

}
