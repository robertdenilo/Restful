<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
     <script>
     $(document).ready(function(){
    	  $("#b01").click(function(){
    	  htmlobj=$.ajax({url:"http://localhost:8080/mySpringMVC/hello/getUsers",
    		  async:false});
    	  $("#myDiv").html(htmlobj.responseText);
    	  });
    	  
    	  
    	  $("#b02").click(function(){
        	  htmlobj=$.ajax({url:"http://localhost:8080/mySpringMVC/hello/getUsersWithJsonParam",
        	      type : 'POST',
        	      dataType:"json",      
        	      contentType:"application/json;charset=UTF-8", 
        	      data: JSON.stringify({'name':"dddd", 'age':"123"}),
        	      
        	      
        	      //traditional: true, 
        	      //data:{ 
        	      //    user: ["ella's papa", "zhouyutong"] 
        	      //},
        	      
        		  //async:false
        		  
        	      success : function(data) {  
                      alert('username : '+data.name+'\npassword : '+data.pwd);  
                  },  
                  error : function(err) {  
                      console.log(err.responseText);
                      alert(err.responseText);
                      
                  }  
        		  
        		  });
        	  $("#myDiv2").html(htmlobj.responseText);
        	  });
    	  
    	  
    	  $("#b03").click(function(){
        	  htmlobj=$.ajax({url:"http://localhost:8080/mySpringMVC/hello/getUsersWithList",
        	      type : 'POST',
        	      dataType:"json",      
        	      contentType:"application/json;charset=UTF-8", 
        	      data: JSON.stringify(["zhouyutong","ella's papa"]),
        	             	      
        	      /* traditional: true, 
        	      data:{ 
        	          user: ["zhouyutong","ella's papa"] 
        	      }, */
        	      
        		  async:false,
        		  
        	      success : function(data) {  
                      alert('username : '+data.name+'\npassword : '+data.pwd);  
                  },  
                  error : function(err) {  
                      console.log(err.responseText);
                      alert(err.responseText);
                      
                  }  
        		  
        		  });
        	  $("#myDiv3").html(htmlobj.responseText);
        	  });
    	});
     
     
     
     </script>


    <form action="http://localhost:8080/mySpringMVC/hello/addUser" method="post">
        <h3>添加用户信息</h3>
                        姓名：<input type="text" name="name" id="name" value="" /> 
        pwd:<input type="pwd" name="pwd" id="pwd" value="" /> 
        <input type="submit" value="提交" />
    </form>
	<div id="myDiv"><h2>Let AJAX change this text</h2></div>
	<button id="b01" type="button">Change Content</button>
  	<div id="myDiv2"><h2>Let AJAX change this text 发送数据，user对象</h2></div>
	<button id="b02" type="button">Change Content2 发送数据，user对象</button>  
	<div id="myDiv3"><h2>Let AJAX change this text 发送数据，数组</h2></div>
	<button id="b03" type="button">Change Content3 发送数据，数组</button>  
</body>
</html>