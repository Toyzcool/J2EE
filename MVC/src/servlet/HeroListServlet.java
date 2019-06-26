package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

// 作用：通过控制器Dao，获取数据放在Request中，并跳转到lishHero.jsp
@SuppressWarnings("serial")
public class HeroListServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Hero> heros = new HeroDAO().list();
		request.setAttribute("heros", heros);
		request.getRequestDispatcher("listHero.jsp").forward(request, response);
	}
}
