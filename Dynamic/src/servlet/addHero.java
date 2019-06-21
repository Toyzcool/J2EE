package servlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class addHero extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 对客户端请求进行重现编码
		request.setCharacterEncoding("UTF-8");
		Hero hero = new Hero();
		hero.setName(request.getParameter("name")); 
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damege")));
		new HeroDAO().add(hero);
		response.sendRedirect("/listHero");
	};
}
