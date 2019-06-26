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
		response.setContentType("text/html; charset=UTF-8");
		// 分页展示
		int start = 0;
		int count = 5;
		// 获取start值，确定翻页起点
		try {
			start = Integer.parseInt(request.getParameter("start")) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 赋值next，确认翻页后的起点
		int next = start + count;
		int pre = start - count;
		// 将next值传递过去，用于更新前端页面的start值
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		// 获取数据库中的值
		List<Hero> heros = new HeroDAO().list(start,count);
		request.setAttribute("heros", heros);
		request.getRequestDispatcher("listHero.jsp").forward(request, response);
	}
}
