package com.prokopchuk.airportmanagementbackend;

import com.prokopchuk.airportmanagementbackend.dao.CrewMemberDao;
import com.prokopchuk.airportmanagementbackend.dao.FlightDao;
import com.prokopchuk.airportmanagementbackend.dao.impl.DefaultCrewMemberDao;
import com.prokopchuk.airportmanagementbackend.dao.impl.DefaultFlightDao;
import com.prokopchuk.airportmanagementbackend.database.DatabaseConnector;
import com.prokopchuk.airportmanagementbackend.model.CrewMember;
import com.prokopchuk.airportmanagementbackend.model.Flight;
import com.prokopchuk.airportmanagementbackend.model.Position;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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

    FlightDao dao = new DefaultFlightDao();
    System.out.println(dao.delete(4L));
    System.out.println(dao.delete(4L));

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "AFFAAFAF" + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}