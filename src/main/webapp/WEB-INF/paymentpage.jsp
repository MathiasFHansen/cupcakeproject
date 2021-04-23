<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du har betalt for din ordre af følgende varer: </h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <td>Antal</td>
                <td>Top</td>
                <td>Bund</td>
                <td>Pris</td>
            </tr>
            </thead>

            <c:forEach var="basketItem" items="${sessionScope.basket.basketItemList}">
                <tr>
                    <td>${basketItem.quantity}</td>
                    <td>${basketItem.cupcakeTop.name}</td>
                    <td>${basketItem.cupcakeBottom.name}</td>
                    <td>${basketItem.price}</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>Pris i alt:</td>
                <td>${sessionScope.basket.totalSum()}</td>
            </tr>
        </table>

        <h2>Du har følgende beløb tilbage på din konto: ${sessionScope.user.balance} </h2>

    </jsp:body>

</t:genericpage>