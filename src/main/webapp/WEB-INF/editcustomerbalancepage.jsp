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


        <form method="post" action="${pageContext.request.contextPath}/fc/editcustomer2">
            <div class="row">
                <div class="form-group col-2"></div>
                <div class="col-8">
                    <table class="table">
                        <thead>
                        <th>User id</th>
                        <th>Email</th>
                        <th>Balance</th>
                        </thead>
                        <c:forEach var="userEntry" items="${requestScope.userEntryList}">
                            <tr>
                                <td>${userEntry.id}</td>
                                <td>${userEntry.email}</td>
                                <td>${userEntry.balance}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <div class="form-group col-2"></div>
            </div>



            <div class="row">
                <div class="form-group col-3"></div>
                <div class="form-group col-3">
                    <label class="col-sm-1 col-form-label" for="id">UserID</label>
                    <input id="id" class="form-control" name="id" value="${requestScope.userEntryId}" placeholder="Enter id of user">
                </div>
                <div class="form-group col-3">
                    <label class="col-sm-1 col-form-label" for="addBalance">Balance</label>
                    <input id="addBalance" class="form-control" name="addBalance" placeholder="Enter money to deposit for user">
                </div>
                <div class="form-group col-3"></div>
            </div>

            <div class="row mt-2">
                <div class="col-8"></div>
                <div class="col-2">
                    <button class="btn btn-primary btn-sm" type="submit" name="update">Confirm</button>
                </div>
                <div class="col-2"></div>
            </div>
        </form>


    </jsp:body>
</t:genericpage>
