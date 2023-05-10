package com.prokopchuk.airportmanagementbackend.web.crewmember;

import com.prokopchuk.airportmanagementbackend.web.AbstractDomainServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "GetCrewMemberByIdServlet")
public class GetCrewMemberByIdServlet extends AbstractDomainServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
