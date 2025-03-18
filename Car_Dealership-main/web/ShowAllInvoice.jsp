<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Invoice For Customer</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.USER}">
            <c:set var="ERROR" value="You need to login first!" scope="request"/>
            <jsp:forward page="MainServlet?action=HOME"/>
        </c:if>
        <div class="container mt-5">
            <h1 class="text-center">Manage Invoice For Customer</h1>
            <hr/>
            <c:if test="${not empty sessionScope.mess}">
                <div class="alert alert-info">${sessionScope.mess}</div>
                <c:remove var="mess" scope="session"/>
            </c:if>

            <p class="text-center">List invoice of customer | 
                <a href="MainServlet?action=CREATE_NEW_INVOICE&custID=${sessionScope.customer_id}" class="btn btn-primary btn-sm">Create new invoice</a> | <a href="MainServlet?action=LOAD_CUSTOMER" class="btn btn-primary btn-sm">Back</a>
            </p>

            <div class="table-responsive">
                <table class="table table-bordered table-striped text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>InvoiceId</th>
                            <th>InvoiceDate</th>
                            <th>Show Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${sessionScope.Invoice}">
                            <tr>                
                                <td>${p.invoiceId}</td>
                                <td>${p.invoiceDate}</td>
                                <td><a href="MainServlet?action=INVOICE_DETAIL_SER&custID=${sessionScope.customer_id}" class="btn btn-info">Details Invoice</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>