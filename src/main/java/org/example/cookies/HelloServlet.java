package org.example.cookies;

import java.io.*;
import java.rmi.ServerError;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "cookie_log", value = "/cookie_log")
public class HelloServlet extends HttpServlet {
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String message;

        boolean flag = false;
        Cookie[] cookies = request.getCookies();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        Integer session = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("Name") && c.getValue().equals(name)) {
                    flag = true;
                    break;
                }
            }


            if (flag) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("Password") && c.getValue().equals(password)) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
        }

        if (!flag) {
            Cookie c1 = new Cookie("Name", name);
            c1.setSecure(false);
            c1.setMaxAge(-1);
            c1.setPath("/");
            response.addCookie(c1);

            Cookie c2 = new Cookie("Password", password);
            c2.setSecure(false);
            c2.setMaxAge(-1);
            c2.setPath("/");
            response.addCookie(c2);

            Cookie numberlog = new Cookie("session", "0");
            numberlog.setSecure(false);
            numberlog.setMaxAge(-1);
            numberlog.setPath("/");
            response.addCookie(numberlog);

            message = "Benvenuto";
        } else {
            message = "Bentornato " + name;

            if (cookies != null) {
                for (Cookie co : cookies) {
                    if (co.getName().equals("session")) {
                        String str = co.getValue();

                        if (str == null) {
                            break;
                        }

                        Integer value = Integer.parseInt(str);
                        value++;
                        session = value;
                        co.setValue(value.toString());
                        response.addCookie(co);
                        break;
                    }
                }
            }
        }

        CookiesData cose = new CookiesData(name, session);
        request.setAttribute("cose", cose);
        RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
        dispatcher.forward(request, response);

        //PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println("<h2> Session " +  session + "</h2>");
        //out.println("</body></html>");
    }


    public void destroy() {
    }
}