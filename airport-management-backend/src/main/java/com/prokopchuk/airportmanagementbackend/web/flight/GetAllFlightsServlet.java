package com.prokopchuk.airportmanagementbackend.web.flight;

import com.prokopchuk.airportmanagementbackend.common.dto.flight.FlightDto;
import com.prokopchuk.airportmanagementbackend.common.dto.flight.FlightListDto;
import com.prokopchuk.airportmanagementbackend.util.WebUtils;
import com.prokopchuk.airportmanagementbackend.web.AbstractDomainServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "getAllFlightsServlet", value = "/flight/list")
public class GetAllFlightsServlet extends AbstractDomainServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    log.info("Request on retrieving all flights");

    List<FlightDto> flights = flightService.findAll();
    FlightListDto result = new FlightListDto(flights);

    WebUtils.sendJson(response, result);
  }

}
