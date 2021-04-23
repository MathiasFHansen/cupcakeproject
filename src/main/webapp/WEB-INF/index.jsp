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

            <h1 class="align-items-center">Velkommen til Olsker cupcakes, login for at bestille.</h1>



                    <c:if test="${sessionScope.role == 'employee' }">
                    <p style="font-size: larger">This is what you can do,
                        since your are logged in as an employee</p>
                    <p><a href="fc/employeepage">Employee Page</a>
                        </c:if>


                        <c:if test="${sessionScope.role == 'customer' }">

                    <h1>Hello ${sessionScope.email} </h1>


                    <p><a href="fc/customerpage">Customer Page</a>
                        </c:if>

                    <div class="col-sm-4"></div>

                </div>
            </div>
        </div>


    </jsp:body>
</t:genericpage>