package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

@SuppressWarnings("serial")
public class HeroListServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		/*
		 * 登陆判断模块
		 */
//		String userName = (String)request.getSession().getAttribute("userName");
//		if (null == userName) {
//            response.sendRedirect("login.html");
//            return;
//        }
		
		/*
		 * 内容展示模块
		 */
			// 分页展示
			int start = 0;
			int count = 5;
			// 确认末页
			int last = 0;
			int total = new HeroDAO().getTotal();
			if(0 == total%count) {
				last = total - count;
			}else {
				last = total - total%count;
			}
			// 获取start值，确定翻页起点
			try {
				start = Integer.parseInt(request.getParameter("start")) ;
			} catch (Exception e) {
			}
			// 赋值next，确认翻页后的起点
			int next = start + count;
			int pre = start - count;
			// 需要进行边界处理
			pre = pre < 0 ? 0 : pre;
			next = next > last ? last : next;
			// 将next值传递过去，用于更新前端页面的start值
			request.setAttribute("next", next);
			request.setAttribute("pre", pre);
			request.setAttribute("last", last);
			// 获取数据库中的值
			List<Hero> heros = new HeroDAO().list(start,count);
			request.setAttribute("heros", heros);
			request.getRequestDispatcher("listHero.jsp").forward(request, response);
	}
}