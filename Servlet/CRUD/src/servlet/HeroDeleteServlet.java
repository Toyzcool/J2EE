package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroDeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		// 对客户端请求进行重现编码
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id")) ;
		new HeroDAO().delete(id);
		
		response.sendRedirect("/listHero");
	}
}
