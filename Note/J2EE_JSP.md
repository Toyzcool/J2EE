

## J2EE

### C.JSP

### 1.简介

#### 方法

1.执行过程

- 浏览器打开.jsp文件
- 服务器收到后转译成Servlet类型文件（原因是继承了HttpServlet类）
- 再编译成.class文件
- 服务器执行，并返回结果给浏览器

2.JSP页面元素

![é¡µé¢åç´ ](http://stepimagewm.how2j.cn/1657.png)

### 2.Include

#### 方法

1.Include方法

- 把页面分模块开发，页首、页尾分别使用include来引入，减少重复开发

2.指令Include，动作Include的实现，见实现1

3.指令Include，动作Include区别

- 指令Include中的内容会加入文件中，并生成一个java文件
- 动作Include中的内容不会加入文件中，会单独生成一个java文件，并在服务器返回的响应中插入内容

4.传参

- 指令Include由于会合并生成一个java文件，因为不存在传参
- 动作Include可以传参，引用文件设置值，被引用文件接受请求过来的参数，见实现1

#### 实现

实现1

```jsp
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!-- 1.输出内容 -->
<%="Hello World" %>
<br>
<%=new Date().toLocaleString()%>

<!-- 2.使用for循环输出 -->
<% 
	List<String> words = new ArrayList();
	words.add("today");
	words.add("is");
	words.add("good");
%>
<table width="200px" align="center" border="1" cellspacing="0">
	<%for(String word : words){%>
		<tr>
			<td align="center"><%= word %> </td>
		</tr>
	<%}%>
</table>
<!-- 指令include -->
<%@ include file="footer.jsp" %>
<!-- 动作include -->
<jsp:include page="footer.jsp" >
	<jsp:param name="year" value="2019"/>
</jsp:include>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<p style="text-align:center">copyright@<%= request.getParameter("year") %>
	</p>
</body>
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/hello.jsp
- Package/J2EE/JSP/JSP/footer.jsp

### 3.Jump跳转

#### 方法

1.使用客户端跳转

2.使用服务器跳转

#### 实现

1.客户端跳转

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试客户端跳转和服务器跳转</title>
</head>
<body>
	<% response.sendRedirect("hello.jsp"); %>
</body>	
</html>
```

2.服务器跳转

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试客户端跳转和服务器跳转</title>
</head>
<body>
	<jsp:forward page="hello.jsp"/>
</body>
			
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/jump.jsp

### 4.Cookie

#### 方法

1.流程

- 客户端访问setCookie.jsp
- 服务器将用户名保存在cookie中，并发送给客户端
- 客户端保存在本地
- 访问getCookie.jsp
- 提交cookie文件，从cookie获取用户名

#### 实现

1.setCookie.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Cookie</title>
</head>
<body>
	<%
		Cookie c = new Cookie("name","Toyz");
		c.setMaxAge(24*60*60);
		c.setPath("/");
		response.addCookie(c);
	%>
</body>
</html>
```

2.getCookie.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(null != cookies)
			for (int d = 0; d <= cookies.length - 1; d++) {
	            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
				}
	%>
</body>
</html>
```

### 5.Session

#### 方法

1.使用session.setAttribute("name","Session")方法设置session参数

2.使用session.getAttribute()方法获取参数

3.session和cookie关系

- session等于盒子
- cookie等于打开相应盒子的钥匙

### 6.作用域

#### 方法

1.pageContext，为当前页面有效

2.requestContext，为当前请求有效

- 如果使用服务器跳转，则可以传参
- 如果使用客户端跳转，则为两次请求，无法传参

3.sessionContext，为会话有效。打开链接后，无论访问多少页面，都属于同一会话中，因此一直有效

4.applicationContext，所有用户共享。本质为ServletContext接口的实例

#### 实现

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>向作用域设置数据</title>
</head>
<body>
<%
	/* 当前页面 */
	pageContext.setAttribute("name", "PageContextData");

	/* 当前用户所属的会话 */
	pageContext.setAttribute("name", "SessionData",pageContext.SESSION_SCOPE);
	
	/* 全局 */
	pageContext.setAttribute("name", "ApplicationData",pageContext.APPLICATION_SCOPE);
%>
	<!-- 当前页面 -->
	页面数据为：<%= pageContext.getAttribute("name") %>，只能在当前页面访问<br>
	
	<!-- 当前用户所属的会话 -->
	会话数据为：<%= pageContext.getAttribute("name",pageContext.SESSION_SCOPE) %>，可用于页面间数据传递<br>
	
	<!-- 全局 -->
	全局数据为：<%= pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE) %>，所有用户共享<br>
</body>
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/setContext.jsp
- Package/J2EE/JSP/JSP/setRequest.jsp

### 9.隐式

#### 方法

1.JSP一共有9个隐式对象，分别是 

- request,response,out 
- pageContext, session,application 
- page,config,exception

2.隐式不需要显示定义，可以直接使用























