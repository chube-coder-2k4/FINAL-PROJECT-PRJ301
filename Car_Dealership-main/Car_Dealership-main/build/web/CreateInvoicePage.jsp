<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Invoice</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${empty sessionScope.USER}">
            <c:set var="ERROR" value="You need to login first!" scope="request"/>
            <jsp:forward page="MainServlet?action=HOME"/>
        </c:if>
        <div class="container mt-5">
            <h1 class="text-center">Manage Invoice For Customer</h1>
            <hr/>
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form action="MainServlet?action=CREATE_INVOICE_CUS" method="post" class="card p-4 shadow-sm">
                        <div class="mb-3">
                            <label class="form-label">Invoice ID</label>
                            <input type="text" name="txtinvoiceid" class="form-control" placeholder="Enter new Invoice ID" required >
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Date</label>
                            <input type="date" name="txtdate" class="form-control" placeholder="Enter format yyyy-mm-dd" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Sales ID</label>
                            <input type="text" name="txtsalesid" class="form-control" value="${sessionScope.USER.salesID}" placeholder="Enter new Sales ID" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Car ID</label>
                            <input type="text" name="txtcarid" class="form-control" placeholder="Enter new Car ID" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Customer ID</label>
                            <input type="text" name="txtcustid" class="form-control" value="${sessionScope.customer_id}" placeholder="Enter new Customer ID" required readonly="">
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>
                    </form>
                    <div class="text-center mt-3">
                        <form action="MainServlet?action=SHOW_INVOICE" method="post">
                            <button type="submit" class="btn btn-secondary">Back</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>