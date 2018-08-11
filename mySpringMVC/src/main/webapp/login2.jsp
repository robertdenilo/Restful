<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme() + "://" +request.getServerName() +"://"+request.getServerPort();
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form id="form1" name="form" method="post" action="hello/viewResult">
       	 用户：<input type="text" name="Name1"/>
       	 密码：<input type="password" name="Pwd1"/>
        input:<input type="submit"/>
     </form>
     
     
     <form id="form2" name="myform2" method="post" action="hello/sayHi">
         user: <input type="text" name="name"/>
       	 pw:<input type="password" name="pwd"/>
        action :<input name = "btn2" type="submit"/>
     </form>
</body>
</html>