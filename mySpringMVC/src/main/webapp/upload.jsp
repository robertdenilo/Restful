<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="hello/uploadfile?urlParam=AAA" method="post" enctype="multipart/form-data"> 
        text:<input type="text" name="formParam" /><br/> 
                       文件:<input type="file" name="formFile" /><br/>
        <input type="submit" value="Submit" />
    </form>  
</body>
</html>