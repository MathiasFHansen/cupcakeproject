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

        <h3>Det her er din nuværende balance på din konto: ${sessionScope.balance} kr.</h3>

        <form name="cupcake dropdowns"  action="${pageContext.request.contextPath}/fc/cupcakechoice" method="post">
                <div class="row">
                    <div class="form-group col-4">
                        <label class="form-check-label" for="cupcakeTop">Cupcake Top:</label>

                        <select class="form-control" name="cupcakeTop" id="cupcakeTop">
                            <c:forEach var="cupcakeTop" items="${applicationScope.cupcakeTopList}">
                                <option value="${cupcakeTop.cupcakeTopId}">${cupcakeTop.name} (${cupcakeTop.price} kr.)</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-4">
                        <label class="form-check-label" for="cupcakeBottom">Cupcake Bund:</label>

                        <select class="form-control" name="cupcakeBottom" id="cupcakeBottom">
                            <c:forEach var="cupcakeBottom" items="${applicationScope.cupcakeBottomList}">
                                <option value="${cupcakeBottom.cupcakeBottomId}">${cupcakeBottom.name} (${cupcakeBottom.price} kr.)</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-4">
                        <label class="form-check-label" for="quantity">quantity:</label>

                        <select class="form-control" name="quantity" id="quantity">
                            <c:forEach var="quantity" begin="1" end="5">
                                <option value="${quantity}">${quantity} stk</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="form-group col-9"></div>
                    <div class="form-group col-3">
                        <button class="btn btn-primary btn-sm" type="submit" name="add to basket">Tilføj til kurv</button>
                    </div>

                </div>

            <br/>
            <br/>



        </form>

        <form name="Send to payment" action="${pageContext.request.contextPath}/fc/PaymentPage">

            <h3>Din indkøbskurv: //TODO: Fix Refresh bug</h3>
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

            <div class="row mt-2">
                <div class="form-group col-9"></div>
                <div class="form-group col-3">
                    <button class="btn btn-primary btn-sm" type="submit" name="add to basket">Tilføj til kurv</button>
                </div>

            </div>


        </form>









    </jsp:body>

</t:genericpage>

