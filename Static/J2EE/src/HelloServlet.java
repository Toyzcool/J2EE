import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	 
public class HelloServlet extends HttpServlet{
	public void init(ServletConfig config) {
		System.out.println("Init of Servlet");
	}
	public void service(HttpServletRequest request, HttpServletResponse response){   
		try {
			//设置缓冲区中使用的编码为UTF-8
			response.setCharacterEncoding("UTF-8");
			//设置浏览器接受内容时所使用的编码方式
			response.setContentType("text/html;charset = UTF-8");
			
			response.getWriter().println("<h1>Hello Servlet!</h1>");
	        response.getWriter().println(new Date());
	        
	        PrintWriter pw = response.getWriter();
	        pw.println("<h2>使用response的getWriters</h2>");
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	     
}