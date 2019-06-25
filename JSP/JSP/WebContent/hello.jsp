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
<jsp:include page="footer.jsp" />