package com.prokopchuk.airportmanagementbackend;

import com.prokopchuk.airportmanagementbackend.dao.CrewMemberFlightRelationDao;
import com.prokopchuk.airportmanagementbackend.dao.impl.DefaultCrewMemberFlightRelationDao;
import com.prokopchuk.airportmanagementbackend.model.CrewMemberFlightRelation;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  private String message;

  public void init() {
    message = "Hello World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    CrewMemberFlightRelationDao dao = new DefaultCrewMemberFlightRelationDao();
    System.out.println(dao.insert(new CrewMemberFlightRelation(1L, 2L)));
    System.out.println(dao.existsByCrewMemberAndFlightIds(1L, 2L));
    System.out.println(dao.deleteByCrewMemberAndFlightIds(1L, 2L));
    System.out.println(dao.existsByCrewMemberAndFlightIds(1L, 2L));
    System.out.println(dao.deleteByCrewMemberAndFlightIds(1L, 2L));

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "AFFAAFAF" + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}