<%-- 
    Document   : topMenu
    Created on : 16/02/2016, 07:50:38
    Author     : 1147106
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <nav class="topMenu">
            <ul>
                <a href="index.jsp"><li class="${menu.equals("home")?"selected-menu":""}">Home</li></a>
                <c:if test="${username != null}">
                    <a href="page1.jsp"><li class="${menu.equals("page1")?"selected-menu":""}">Página 1</li></a>
                </c:if>
                <c:choose>
                    <c:when test="${username == null}">
                        <a href="login.jsp"><li class="${menu.equals("login")?"selected-menu":""}">Login</li></a>
                    </c:when>
                    <c:otherwise>
                        <a href="home?command=User&action=logout"><li>Logout</li></a>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </body>
</html>
