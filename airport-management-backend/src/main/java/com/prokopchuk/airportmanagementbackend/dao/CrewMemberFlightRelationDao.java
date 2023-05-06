package com.prokopchuk.airportmanagementbackend.dao;

import com.prokopchuk.airportmanagementbackend.model.CrewMemberFlightRelation;

public interface CrewMemberFlightRelationDao {

  CrewMemberFlightRelation insert(CrewMemberFlightRelation relation);

  boolean existsByCrewMemberAndFlightIds(Long crewMemberId, Long flightId);

  boolean deleteByCrewMemberAndFlightIds(Long crewMemberId, Long flightId);

}
