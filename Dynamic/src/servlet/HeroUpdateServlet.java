package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroUpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id")) ;
		
		Hero hero = new HeroDAO().get(id);
		
		StringBuffer format = new StringBuffer();
		response.setContentType("text/html; charset=UTF-8");
		
		format.append(" <Form action='updateHero' method='post'> ");
		format.append(" 名字：<input type='text' name='name' value='%s'> <br> ");
	}
}
