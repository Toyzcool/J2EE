package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroEditServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		
		// 获取需要更新的英雄
		Hero hero = new HeroDAO().get(id);
		
		StringBuffer format = new StringBuffer();
		response.setContentType("text/html; charset=UTF-8");
		
		// 提交修改的表格
		format.append(" <Form action='updateHero' method='post'> ");
		format.append(" 名字：<input type='text' name='name' value='%s'> <br> ");
		format.append(" 血量：<input type='text' name='hp' value='%f'> <br> ");
		format.append(" 攻击：<input type='text' name='damage' value='%d'> <br> ");
		format.append(" <input type='hidden' name='id' value='%d'> <br> ");	// 用于传输ID
		format.append(" <input type='submit' value='提交'> <br> ");
		format.append(" </form> ");
		String html = String.format(format.toString(),hero.getName(),hero.getHp(),hero.getDamage(),hero.getId());
		
		response.getWriter().write(html);
	}
}
