<%-- 
    Document   : index
    Created on : Feb 7, 2017, 10:20:22 PM
    Author     : Chris Palmer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:include page="resources/partialPages/scripts.jsp"></jsp:include>
         
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="resources/partialPages/navbar.jsp"></jsp:include>
    </body>
</html>
