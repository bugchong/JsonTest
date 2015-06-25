<%@page import="com.kuhn.jsondb.Doget"%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>测试JSON</title>
</head>
<body>
<form action="Doget" method="get">
<h3>代码：</h3><input type="text" name="stockcode" value="" title="必须为数字"></input>
<input type="submit" value="查询"/>
</form>
<br>
<br>
<table border="1">  
        <tr>  
            <td>编号</td>  
            <td>代码</td>  
            <td>名称</td>  
            <td>公告标题</td>                    
            </tr>    
           </table>
     
</body>
</html>