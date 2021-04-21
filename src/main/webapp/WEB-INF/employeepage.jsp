<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Hello you are now logged in as an employee
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        <form method="post" action="">
            <p> <a href="${pageContext.request.contextPath}/fc/editcustomer"> Gå til visning af customers og deres balance</a> </p>

        </form>

    </jsp:body>
</t:genericpage>
