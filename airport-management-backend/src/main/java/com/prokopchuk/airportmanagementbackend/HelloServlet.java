package com.prokopchuk.airportmanagementbackend;

import com.prokopchuk.airportmanagementbackend.database.DatabaseConnector;
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

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "AFFAAFAF" + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}