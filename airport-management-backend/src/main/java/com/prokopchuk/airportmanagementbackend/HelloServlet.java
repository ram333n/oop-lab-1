package com.prokopchuk.airportmanagementbackend;

import com.prokopchuk.airportmanagementbackend.dao.CrewMemberDao;
import com.prokopchuk.airportmanagementbackend.dao.CrewMemberFlightRelationDao;
import com.prokopchuk.airportmanagementbackend.dao.impl.DefaultCrewMemberDao;
import com.prokopchuk.airportmanagementbackend.dao.impl.DefaultCrewMemberFlightRelationDao;
import com.prokopchuk.airportmanagementbackend.model.CrewMemberFlightRelation;
import com.prokopchuk.airportmanagementbackend.service.mapper.CrewMemberMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Slf4j
@WebServlet(name = "helloServlet", value = "/hello-servlet/{aboba}")
public class HelloServlet extends HttpServlet {

  private String message;

  public void init() {
    message = "Hello World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    CrewMemberDao dao = new DefaultCrewMemberDao();

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "AFFAAFAF" + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}