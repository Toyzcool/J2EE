package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroUpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 新建英雄对象
		Hero hero = new Hero();
		
		// 获取英雄各个属性,并使用赋值方法
		hero.setId(Integer.parseInt(request.getParameter("id")));
		hero.setName(request.getParameter("name")); 
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damage")));
		
		new HeroDAO().update(hero);
		
		response.sendRedirect("/listHero");
	}
}
