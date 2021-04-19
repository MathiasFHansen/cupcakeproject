<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="text-center">

                    <h2>Our Cool Site</h2>

                    <div style="margin-top: 3em;margin-bottom: 3em;">
                        Main page for this 2. semester start project used at cphbusiness.dk
                    </div>

                    <div class="jumbotron">
                        <h1 class="display-4">Hello, world!</h1>
                        <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                        <hr class="my-4">
                        <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
                        <p class="lead">
                            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
                        </p>
                    </div>


                    <c:if test="${sessionScope.role == 'employee' }">
                    <p style="font-size: larger">This is what you can do,
                        since your are logged in as an employee</p>
                    <p><a href="fc/employeepage">Employee Page</a>
                        </c:if>

                        <c:if test="${sessionScope.role == 'customer' }">
                    <p style="font-size: larger">This is what you can do, since your
                        are logged in as a customer</p>
                    <p><a href="fc/customerpage">Customer Page</a>
                        </c:if>

                    <div class="col-sm-4"></div>

                </div>
            </div>
        </div>


    </jsp:body>
</t:genericpage>