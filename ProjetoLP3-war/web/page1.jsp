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
        <c:set var="menu" scope="session" value="page1"></c:set>
        <c:if test="${username == null}">
            <c:redirect url="home?command=User&action=logerror"></c:redirect>
        </c:if>
        <%@include file="topMenu.jsp" %>
        <h1>PAGE 1</h1>
    </body>
</html>
