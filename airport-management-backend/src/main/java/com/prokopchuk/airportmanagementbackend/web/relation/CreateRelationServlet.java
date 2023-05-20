package com.prokopchuk.airportmanagementbackend.web.relation;

import com.prokopchuk.airportmanagementbackend.common.dto.ErrorMessage;
import com.prokopchuk.airportmanagementbackend.common.dto.relation.CrewMemberFlightRelationDto;
import com.prokopchuk.airportmanagementbackend.util.WebUtils;
import com.prokopchuk.airportmanagementbackend.web.AbstractDomainServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "createRelationServlet", value = "/relation/create")
public class CreateRelationServlet extends AbstractDomainServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String crewMemberIdStr = request.getParameter("crewMemberId");
    String flightIdStr = request.getParameter("flightId");
    log.info("Request on creating relation. Crew member id: {}, flight id: {}", crewMemberIdStr, flightIdStr);

    Long crewMemberId = Long.valueOf(crewMemberIdStr);
    Long flightId = Long.valueOf(flightIdStr);
    CrewMemberFlightRelationDto toCreate = new CrewMemberFlightRelationDto(crewMemberId, flightId);

    boolean isCreated = relationService.create(toCreate);

    if (isCreated) {
      WebUtils.sendJson(response, "", HttpServletResponse.SC_CREATED);
    } else {
      ErrorMessage message = ErrorMessage.of(
          "relation_already_exists",
          "Relation already exists"
      );
      WebUtils.sendJson(response, message, HttpServletResponse.SC_BAD_REQUEST);
    }
  }

}