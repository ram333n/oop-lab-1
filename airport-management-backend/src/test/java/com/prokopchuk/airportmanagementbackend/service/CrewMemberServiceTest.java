package com.prokopchuk.airportmanagementbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.prokopchuk.airportmanagementbackend.common.dto.crewmember.CrewMemberDto;
import com.prokopchuk.airportmanagementbackend.dao.CrewMemberDao;
import com.prokopchuk.airportmanagementbackend.dao.CrewMemberFlightRelationDao;
import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import com.prokopchuk.airportmanagementbackend.model.Position;
import com.prokopchuk.airportmanagementbackend.service.impl.DefaultCrewMemberService;
import com.prokopchuk.airportmanagementbackend.service.mapper.CrewMemberMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class CrewMemberServiceTest {

  private final CrewMemberDao crewMemberDao = Mockito.mock(CrewMemberDao.class);
  private final CrewMemberService service = new DefaultCrewMemberService(crewMemberDao);
  private final CrewMemberMapper mapper = Mappers.getMapper(CrewMemberMapper.class);

  @Test
  void findAllWorksProperly() {
    List<CrewMember> entities = List.of(
        CrewMember.builder()
            .id(1L)
            .name("Test name 1")
            .surname("Test surname 1")
            .position(Position.PILOT)
            .build(),

        CrewMember.builder()
            .id(2L)
            .name("Test name 2")
            .surname("Test surname 2")
            .position(Position.OPERATOR)
            .build()
    );

    Mockito.when(crewMemberDao.findAll()).thenReturn(entities);

    List<CrewMemberDto> actual = service.findAll();
    List<CrewMemberDto> pilots = actual.stream()
        .filter(cm -> Objects.equals(cm.getPosition(), Position.PILOT))
        .collect(Collectors.toList());

    List<CrewMemberDto> operators = actual.stream()
        .filter(cm -> Objects.equals(cm.getPosition(), Position.OPERATOR))
        .collect(Collectors.toList());

    assertEquals(2, actual.size());
    assertEquals(1, pilots.size());
    assertEquals(1, operators.size());
    assertEquals(1L, pilots.get(0).getId());
    assertEquals(2L, operators.get(0).getId());
  }

  @Test
  void findAllByFlightIdWorksProperly() {
    Long flightId = 1L;
    List<CrewMember> entities = List.of(
        CrewMember.builder()
            .id(1L)
            .name("Test name 1")
            .surname("Test surname 1")
            .position(Position.PILOT)
            .build(),

        CrewMember.builder()
            .id(2L)
            .name("Test name 2")
            .surname("Test surname 2")
            .position(Position.OPERATOR)
            .build()
    );

    Mockito.when(crewMemberDao.findAllByFlightId(flightId)).thenReturn(entities);

    List<CrewMemberDto> actual = service.findAllByFlightId(flightId);

    List<CrewMemberDto> pilots = actual.stream()
        .filter(cm -> Objects.equals(cm.getPosition(), Position.PILOT))
        .collect(Collectors.toList());

    List<CrewMemberDto> operators = actual.stream()
        .filter(cm -> Objects.equals(cm.getPosition(), Position.OPERATOR))
        .collect(Collectors.toList());

    assertEquals(2, actual.size());
    assertEquals(1, pilots.size());
    assertEquals(1, operators.size());
    assertEquals(1L, pilots.get(0).getId());
    assertEquals(2L, operators.get(0).getId());
  }

  @Test
  void findByIdWhenProvidedNonExistentId() {
    Long id = 1L;
    Mockito.when(crewMemberDao.findById(id)).thenReturn(Optional.empty());

    Optional<CrewMemberDto> actual = service.findById(id);

    assertTrue(actual.isEmpty());
  }

  @Test
  void findByIdWhenProvidedExistentId() {
    Long id = 1L;
    CrewMember found = CrewMember.builder()
        .id(1L)
        .name("Test name 1")
        .surname("Test surname 1")
        .position(Position.PILOT)
        .build();

    Mockito.when(crewMemberDao.findById(id)).thenReturn(Optional.of(found));

    Optional<CrewMemberDto> actual = service.findById(id);

    assertTrue(actual.isPresent());
    assertEquals(1L, actual.get().getId());
    assertEquals("Test name 1", actual.get().getName());
    assertEquals("Test surname 1", actual.get().getSurname());
    assertEquals(Position.PILOT, actual.get().getPosition());
  }

  @Test
  void createWorksProperly() {
    CrewMemberDto toCreate = CrewMemberDto.builder()
        .name("Test name 1")
        .surname("Test surname 1")
        .position(Position.PILOT)
        .build();

    CrewMemberDto expected = CrewMemberDto.builder()
        .id(1L)
        .name("Test name 1")
        .surname("Test surname 1")
        .position(Position.PILOT)
        .build();

    Mockito.when(crewMemberDao.insert(mapper.toEntity(toCreate)))
        .thenReturn(mapper.toEntity(expected));

    CrewMemberDto actual = service.create(toCreate);

    assertEquals(expected, actual);
  }

  @Test
  void updateWorksProperly() {
    CrewMemberDto toUpdate = CrewMemberDto.builder()
        .id(1L)
        .name("Updated test name 1")
        .surname("Updated test surname 1")
        .position(Position.PILOT)
        .build();

    CrewMemberDto expected = CrewMemberDto.builder()
        .id(1L)
        .name("Updated test name 1")
        .surname("Updated test surname 1")
        .position(Position.PILOT)
        .build();

    Mockito.when(crewMemberDao.update(mapper.toEntity(toUpdate)))
        .thenReturn(mapper.toEntity(expected));

    CrewMemberDto actual = service.update(toUpdate);

    assertEquals(expected, actual);
  }

  @Test
  void deleteWhenProvidedNonExistentId() {
    Long id = 1L;
    Mockito.when(crewMemberDao.delete(id)).thenReturn(false);

    boolean actual = service.delete(id);

    assertFalse(actual);
  }

  @Test
  void deleteWhenProvidedExistentId() {
    Long id = 1L;
    Mockito.when(crewMemberDao.delete(id)).thenReturn(true);

    boolean actual = service.delete(id);

    assertTrue(actual);
  }

}