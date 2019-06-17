## J2EE

### B.Servlet

### 1.简介

#### 方法

1.流程

- html网页的form形式提交请求，action为login，method为post
- tomcat收到请求，通过web.xml文件查找到/login路径，匹配到LoginServlet类
- 调用LoginServlet中的doPost方法
- Servlet工作完成
- tomcat拿到response后，通过HTTP传输协议到html
- 见实现1

2.Get方式的情况

- Form的默认提交方式
- 通过超链接访问
- 通过输入网址访问
- ajax指定使用get方式

3.Post方式的情况

- Form指定使用post方式
- ajax指定使用post方式

4.Service()，用于判断使用get还是post方式，在doGet和doPost方式前会先调用此方式

5.Servlet是什么？——important重要！

- Servlet类似Java中的一个类，用于处理tomcat分发过来的数据，不直接和客户端交互
- 核心包括三个方法，init(),service(),destory()
- init方法为：初始化时需要做什么
- service方法为：收到请求后需要做什么
- destroy方法为：销毁后需要做什么

#### 实现

1.实现1

- Login.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		账号: <input type="text" name="name"> <br>
		密码: <input type="password" name="password"> <br>
		<input type="submit" value="登录">
	</form>

</body>
</html>
```

- Web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
 
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
 
 	<servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>  
    
</web-app>
```

- LoginServlet.java

```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String html = null;
        if ("admin".equals(name) && "123".equals(password))
            html = "<div style='color:green'>success</div>";
        else
            html = "<div style='color:red'>fail</div>";
        PrintWriter pw = response.getWriter();
        pw.println(html);
        
    }
}
```

#### 注意

1.由于init仅仅在tomcat建立时运行一次，因此希望类的内容修改能够随时更新，则需要设置web.xml文件中的reloadable="trues"

#### 索引

- Users/toyz/Package/J2EE/LoginServlet.java
- Users/toyz/Package/J2EE/Web.xml
- Users/toyz/Package/J2EE/Login.html

### 2.跳转

#### 方法

1.跳转分为服务器跳转和客户端跳转

2.服务器跳转

- 服务器调用Servlet方法
- 确认账号密码正确
- 在服务器内容打开success.html

3.客户端跳转

- 服务器调用Servlet方法
- 确认账号密码正确
- 服务器发给浏览器信息，让浏览器打开的success.html
- 访问success.html
- 服务器将将网页内容发送给浏览器

#### 实现

1.LoginServlet.java

```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if ("admin".equals(name) && "123".equals(password))
        	request.getRequestDispatcher("success.html").forward(request,response);
        else
            response.sendRedirect("fail.html");
        
    }
}
```

#### 注意

- 服务器跳转，网址不会改变；客户端跳转，网址将变为fail.html

#### 索引

- Users/toyz/Package/J2EE/LoginServlet.java