<%-- 
    Document   : login
    Created on : May 16, 2017, 4:31:34 PM
    Author     : LAKHE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="shared/header.jsp" %>
<h3>Login Form</h3>

<h1>Spring custom login page</h1>
        <form method="get" action="${pageContext.request.contextPath}/login/sucess">
            <div>
                <label>User Name</label>
                <input type="text" name="UserName" required="required"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" required="required"/>
            </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Save</button>
        </form>


<%@include file="shared/footer.jsp" %>