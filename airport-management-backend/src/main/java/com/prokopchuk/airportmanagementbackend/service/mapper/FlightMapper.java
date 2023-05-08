package com.prokopchuk.airportmanagementbackend.service.mapper;

import com.prokopchuk.airportmanagementbackend.common.dto.flight.FlightDto;
import com.prokopchuk.airportmanagementbackend.model.Flight;
import org.mapstruct.Mapper;

@Mapper
public abstract class FlightMapper {

  public abstract FlightDto toDto(Flight entity);

  public abstract Flight toEntity(FlightDto dto);

}
