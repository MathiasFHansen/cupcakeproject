<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        <form name="cupcake dropdowns"  action="${pageContext.request.contextPath}/fc/cupcakechoice" method="post">
                <div class="row">
                    <div class="form-group col-2"></div>
                    <div class="form-group col-3">
                        <label class="form-check-label" for="cupcakeTop">Cupcake Top:</label>

                        <select class="form-control" name="cupcakeTop" id="cupcakeTop">
                            <c:forEach var="cupcakeTop" items="${applicationScope.cupcakeTopList}">
                                <option value="${cupcakeTop.cupcakeTopId}">${cupcakeTop.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-2"></div>
                    <div class="form-group col-3">
                        <label class="form-check-label" for="cupcakeTop">Cupcake Bund:</label>

                        <select class="form-control" name="cupcakeBottom" id="cupcakeBottom">
                            <c:forEach var="cupcakeBottom" items="${applicationScope.cupcakeBottomList}">
                                <option value="${cupcakeTop.cupcakeBottomId}">${cupcakeBottom.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-2"></div>
                </div>

                <div class="row mt-2">
                    <div class="form-group col-9"></div>
                    <div class="form-group col-3">
                        <button class="btn btn-primary btn-sm" type="submit" name="add to basket" value="">Tilføj til kurv</button>
                    </div>

                </div>

        </form>






        <table class="table">
            <thead><th>Cupcake top</th><th>Cupcake Bund</th><th>Pris</th></thead>
            <c:forEach var="cupcake" items="${requestScope.cupcakeList}">
                <tr>
                    <td>${cupcake}</td>
                    <td>${bmiEntry.bmi}</td>
                    <td>${bmiEntry.height}</td>
                </tr>
            </c:forEach>

        </table>









    </jsp:body>

</t:genericpage>

