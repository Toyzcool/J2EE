package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置浏览器接受内容时所使用的编码方式
		response.setContentType("text/html;charset = UTF-8");
		// 获取英雄列表
		List<Hero> heros = new HeroDAO().list();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table align='center' border='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>update</td><td>delete</td></tr>");
		
		String trForm = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href = 'updateHero?id=%d'>update</a></td><td><a href = 'deleteHero?id=%d'>delete</a></td></tr>";
		for (Hero hero : heros) {
			String tr = String.format(trForm, hero.getId(),hero.getName(),hero.getHp(),hero.getDamage(), hero.getId(),hero.getId());
			sb.append(tr);
		}
		sb.append("</table>");
		
		response.getWriter().write(sb.toString());
	}
}
