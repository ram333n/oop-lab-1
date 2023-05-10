package com.prokopchuk.airportmanagementbackend.service.mapper;

import com.prokopchuk.airportmanagementbackend.common.dto.relation.CrewMemberFlightRelationDto;
import com.prokopchuk.airportmanagementbackend.model.CrewMemberFlightRelation;
import org.mapstruct.Mapper;

@Mapper
public abstract class CrewMemberFlightRelationMapper {

  public abstract CrewMemberFlightRelationDto toDto(CrewMemberFlightRelation entity);

  public abstract CrewMemberFlightRelation toEntity(CrewMemberFlightRelationDto dto);

}
