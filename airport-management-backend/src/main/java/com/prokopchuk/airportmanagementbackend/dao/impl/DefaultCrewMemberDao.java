package com.prokopchuk.airportmanagementbackend.dao.impl;

import com.prokopchuk.airportmanagementbackend.dao.CrewMemberDao;
import com.prokopchuk.airportmanagementbackend.database.DatabaseConnector;
import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import com.prokopchuk.airportmanagementbackend.model.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultCrewMemberDao implements CrewMemberDao {

  @Override
  public Optional<CrewMember> findById(Long id) {
    String sql = "SELECT * FROM crew_members WHERE id = ?";

    try (Connection connection = DatabaseConnector.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, id);
      Optional<CrewMember> result = Optional.empty();

      try (ResultSet rs = statement.executeQuery()) {
        if (rs.next()) {
          result = Optional.of(extractCrewMember(rs));
        }
      }

      return result;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private CrewMember extractCrewMember(ResultSet rs) throws SQLException {
    CrewMember crewMember = new CrewMember();
    crewMember.setId(rs.getLong("id"));
    crewMember.setName(rs.getString("name"));
    crewMember.setSurname(rs.getString("surname"));
    crewMember.setPosition(Position.valueOf(rs.getString("position")));

    return crewMember;
  }

  @Override
  public CrewMember insert(CrewMember toInsert) {
    return null;
  }

  @Override
  public CrewMember update(CrewMember toUpdate) {
    return null;
  }

  @Override
  public boolean delete(Long id) {
    return false;
  }

}
