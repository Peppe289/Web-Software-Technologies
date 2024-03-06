package org.example.primaapp;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "do-nothing", value = "/do-nothing")
public class Yettodo extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        out.print("<head><body>");
        out.print("<h1> Ciao " + name + " " + cognome + "</h1>");
        out.print("<p>" + email + "</p>");
        out.print("</body></head>");
    }

    public void destroy() {
    }
}