<%-- 
    Document   : login
    Created on : May 14, 2017, 10:28:28 PM
    Author     : LAKHE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Spring custom login page</h1>
        <form method="post">
            <div>
                <label>User Name</label>
                <input type="text" name="username" required="required"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" required="required"/>
            </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Save</button>
        </form>
            
                <c:if test="${param.error!=null}">
                    <div style="color:red">error!!!</div>
                </c:if>
            
    </body>
</html>
