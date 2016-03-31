<%-- 
    Document   : page1
    Created on : 16/02/2016, 08:16:07
    Author     : 1147106
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto Base</title>
    </head>
    <body>
        <c:set var="menu" scope="session" value="login"></c:set>
        <%@include file="topMenu.jsp" %>
        <p>${errormsg}</p>
        <c:set var="errormsg" scope="session" value=""></c:set>
            <h1>LOGIN</h1>
            <form method="POST" action="home">
                <input type="hidden" name="command" value="User"/>
                <input type="hidden" name="action" value="login"/>
                <p><input type="text" name="username" placeholder="username" value="${cookie.usernameCookie.value}"/></p>
            <p><input type="password" name="password" placeholder="password" value="${cookie.pwdCookie.value}"/></p>
            <p><input type="checkbox" name="checkSave" checked="checked"/>Lembrar usuario e senha</p>
            <p><input type="submit" value="LOGIN"/></p>
        </form>
    </body>
</html>
