import java.io.IOException;
import java.util.Date;
  
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet{
  
    @SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response){
    	//设置缓冲区中使用的编码为UTF-8
    	response.setCharacterEncoding("UTF-8");
    	//设置浏览器接受内容时所使用的编码方式
    	response.setContentType("text/html;charset = UTF-8"); 
    	
        try {
            response.getWriter().println("<h1>Hello Servlet!</h1>");
            response.getWriter().println(new Date().toLocaleString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
}