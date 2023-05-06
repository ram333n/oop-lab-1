package com.prokopchuk.airportmanagementbackend.dao;

import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import java.util.List;
import java.util.Optional;

public interface CrewMemberDao {

  List<CrewMember> findAll();

  List<CrewMember> findAllByFlightId(Long flightId);

  Optional<CrewMember> findById(Long id);

  CrewMember insert(CrewMember toInsert);

  CrewMember update(CrewMember toUpdate);

  boolean delete(Long id);

}
