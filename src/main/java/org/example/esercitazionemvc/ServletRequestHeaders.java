package org.example.esercitazionemvc;

import java.io.*;
import java.util.Collections;
import java.util.List;

import Model.HeadersBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "index", value = "/index.html")
public class ServletRequestHeaders extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HeadersBean headers = new HeadersBean();
        List<String> headerNames = Collections.list(request.getHeaderNames());

        for (String name : headerNames) {
            String value = request.getHeader(name);

            headers.addHeaderValues(value);
            headers.addHeaderNames(name);
        }

        request.setAttribute("headers", headers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/showHeaders.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}