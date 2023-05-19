package com.prokopchuk.airportmanagementbackend.web;

import com.prokopchuk.airportmanagementbackend.service.CrewMemberFlightRelationService;
import com.prokopchuk.airportmanagementbackend.service.CrewMemberService;
import com.prokopchuk.airportmanagementbackend.service.FlightService;
import com.prokopchuk.airportmanagementbackend.service.impl.DefaultCrewMemberFlightRelationService;
import com.prokopchuk.airportmanagementbackend.service.impl.DefaultCrewMemberService;
import com.prokopchuk.airportmanagementbackend.service.impl.DefaultFlightService;
import jakarta.servlet.http.HttpServlet;


public abstract class AbstractDomainServlet extends HttpServlet {

  protected CrewMemberService crewMemberService;
  protected FlightService flightService;
  protected CrewMemberFlightRelationService relationService;

  @Override
  public void init() {
    this.crewMemberService = new DefaultCrewMemberService();
    this.flightService = new DefaultFlightService();
    this.relationService = new DefaultCrewMemberFlightRelationService();
  }

}
