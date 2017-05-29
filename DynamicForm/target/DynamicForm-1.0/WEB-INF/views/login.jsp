<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="shared/header.jsp" %>
        <h1>login page</h1>
        <h2>Spring custom login page</h2>
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
            <button type="submit">Login</button>
        </form>
            
            
            
                <c:if test="${param.error!=null}">
                    <div style="color:red">error!!!</div>
                </c:if>
            
    <%@include file="shared/footer.jsp" %>