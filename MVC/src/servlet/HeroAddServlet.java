package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;


public class HeroAddServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 获取请求中的参数
		String name = request.getParameter("name");
		float hp = Float.parseFloat(request.getParameter("hp")) ;
		int damage = Integer.parseInt(request.getParameter("damage"));
		
		// 将请求中的参数赋值为Hero对象
		Hero hero = new Hero();
		hero.setName(name);
		hero.setHp(hp);
		hero.setDamage(damage);
		new HeroDAO().add(hero);
		
		response.sendRedirect("listHero");
		}
		
	}

