package com.prokopchuk.airportmanagementbackend.service.mapper;

import com.prokopchuk.airportmanagementbackend.common.dto.crewmember.CrewMemberDto;
import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import org.mapstruct.Mapper;

@Mapper
public abstract class CrewMemberMapper {

  public abstract CrewMemberDto toDto(CrewMember entity);

  public abstract CrewMember toEntity(CrewMemberDto dto);

}
