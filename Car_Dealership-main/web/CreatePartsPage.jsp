<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Parts</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <c:if test="${empty sessionScope.USER}">
        <c:set var="ERROR" value="You need to login first!" scope="request"/>
        <jsp:forward page="MainServlet?action=HOME"/>
    </c:if>
    <div class="container mt-5">
        <h1 class="text-center">Manage Parts</h1>
        <hr/>
        <p class="text-center">Welcome to the list of parts</p>

        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="MainServlet?action=CREATE_PARTS_SUCCESS" method="post" class="card p-4 shadow-sm">
<!--                    <div class="mb-3">
                        <label class="form-label">Parts ID</label>
                        <input type="number" id="txtid" name="txtid" class="form-control" placeholder="Enter a new Parts ID" required>
                    </div>-->
                    <div class="mb-3">
                        <label class="form-label">Parts Name</label>
                        <input type="text" id="txtname" name="txtname" class="form-control" placeholder="Enter a new Parts Name" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Purchase Price</label>
                        <input type="number" id="txtpurchase" name="txtpurchase" class="form-control" placeholder="Enter a new Purchase Price" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Retail Price</label>
                        <input type="number" id="txtretail" name="txtretail" class="form-control" placeholder="Enter a new Retail Price" required>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
                <div class="text-center mt-3">
                    <form action="MainServlet?action=DASHBOARD_PARTS" method="post">
                        <button type="submit" class="btn btn-secondary">Back</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>