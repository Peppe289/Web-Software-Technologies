package org.example.primaapp;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "do-nothing", value = "/do-nothing")
public class Yettodo extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Pagina bianca obv" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}