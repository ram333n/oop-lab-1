package com.prokopchuk.airportmanagementbackend.dao;

import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import java.util.Optional;

public interface CrewMemberDao {

  Optional<CrewMember> findById(Long id);

  CrewMember insert(CrewMember toInsert);

  CrewMember update(CrewMember toUpdate);

  boolean delete(Long id);

}
