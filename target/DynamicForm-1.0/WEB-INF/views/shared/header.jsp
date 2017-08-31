<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL"  value="${pageContext.request.contextPath}" />


<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dynamic Form</title>
        <style type="text/css">
            
        </style>
    </head>
    <body style="background:black">
        <div class="container" id="top-header" style="background:palegoldenrod;">
            
            <table style="width: 100%; height: 40px; vertical-align: middle; table-layout: fixed; border-radius: 5px;">
                <tr>
                    <td><a href="${SITE_URL}"><span class="glyphicon glyphicon-home"></span> Home</a></td>
                    <td align="center"><img src="${pageContext.request.contextPath}/assets/img/formlogo.svg" height="35" width="35"/></td>
                    <td align="right">
                        
                             
                            <a href="${SITE_URL}/login"><span class="glyphicon glyphicon-log-in"></span> Log In</a> | <a href="${SITE_URL}/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a>
                        
                    </td>
                </tr>
            </table>
        </div>
        <div class="container" style="background:white">