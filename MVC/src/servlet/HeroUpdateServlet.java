package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroUpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 获取请求中的参数
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float hp = Float.parseFloat(request.getParameter("hp")) ;
		int damage = Integer.parseInt(request.getParameter("damage"));
		// 新建英雄对象
		Hero hero = new Hero();
		hero.setId(id);
		hero.setName(name);
		hero.setHp(hp);
		hero.setDamage(damage);
		// 更新英雄
		new HeroDAO().update(hero);
		
		response.sendRedirect("listHero");
	}
}
