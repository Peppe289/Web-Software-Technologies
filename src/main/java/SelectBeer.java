
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/** NON MVC Servlet that prints out the Beers of the selected color</a>. */

//@WebServlet(name="SelectBeer", value="/SelectBeer1", initParams={@WebInitParam(name="saluto", value ="Ciao"), @WebInitParam(name="nome", value ="Amico")})
public class SelectBeer extends HttpServlet {

	private String saluto, nome;

	public void init(ServletConfig config)
	throws ServletException{
		super.init(config);
		//saluto = config.getInitParameter("saluto");
		//nome = config.getInitParameter("nome");
	}

	@Override
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) 
							  throws ServletException, IOException {
		
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

		//out.println(saluto + " " + nome +"<br>");
		//out.println("Beer Selection Advice<br>");

		String c = request.getParameter("color");
		List<String> list = new BeerExpert().getBrands(c);

		request.setAttribute("cose", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);

		//out.println("<br>Got beer color " + c + "<br>");

		//for (String str : list) {
		//	out.println("<br>try: " + str);
		//}

		// int i = 5/0;     // divisione per 0 : internal error

	}
}


