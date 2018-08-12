<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <form id="form2" name="myform" method="get" action="http://localhost:8080/mySpringMVC/hello/login">
     output<input type="submit"/>
     </form> 
    <p>用户是： ${Name}</p>
    <p>密码是：${Pwd}</p>
    <p>年龄是：${Age}</p>
</body>
</html>