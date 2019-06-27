package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if ("admin".equals(name) && "123".equals(password)) {
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("listHero.jsp");
		}else{
			response.sendRedirect("login.html");
		}
	}
}
