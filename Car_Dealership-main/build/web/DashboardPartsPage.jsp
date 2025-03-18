<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Parts</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <c:if test="${empty sessionScope.USER}">
            <c:set var="ERROR" value="You need to login first!" scope="request"/>
            <jsp:forward page="MainServlet?action=HOME"/>
        </c:if>
        
        


        <div class="container mt-5">
            <h1 class="text-center">Manage Parts</h1>
            <hr/>

            <c:if test="${not empty sessionScope.mess}">
                <div class="alert alert-info">${sessionScope.mess}</div>
                <c:remove var="mess" scope="session"/>
            </c:if>

            <p class="text-center">Welcome to the list of parts | 
                <a href="MainServlet?action=CREATE_PARTS" class="btn btn-primary btn-sm">Create</a> 
                <a href="MainServlet?action=DASHBOARD" class="btn btn-secondary btn-sm">Back</a>
            </p> 

            <form action="MainServlet?action=SEARCH_PARTS" method="post" class="d-flex mb-3">
                <input type="text" name="txtname" class="form-control me-2" placeholder="Search by name">
                <button type="submit" class="btn btn-primary" >Search</button>
            </form>

            <table class="table table-bordered table-striped text-center">
                <thead class="table-dark">
                    <tr>
                        <th>PartID</th>
                        <th>PartName</th>
                        <th>PurchasePrice</th>
                        <th>RetailPrice</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${sessionScope.parts}">
                        <tr>
                    <form action="MainServlet?action=UPDATE_PARTS" method="post" onsubmit="return confirmUpdate();">
                        <td><input type="number" value="${p.partId}" name="txtid" class="form-control" readonly/></td>
                        <td><input type="text" value="${p.partName}" name="txtname" class="form-control"/></td>
                        <td><input type="number" value="${p.purchasePrice}" name="txtpurchase" class="form-control"/></td>
                        <td><input type="number" value="${p.retailPrice}" name="txtretail" class="form-control"/></td>
                        <td><button type="submit" class="btn btn-success">Update</button></td>
                    </form>
                    <form action="MainServlet?action=DELETE_PARTS" method="post" onsubmit="return confirmDelete();">
                        <input type="hidden" value="${p.partId}" name="txtid"/>
                        <td><button type="submit" class="btn btn-danger">Delete</button></td>
                    </form>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <script>
            function confirmDelete() {
                return confirm("Are you sure to Delete?");
            }
            function confirmUpdate() {
                return confirm("Are you sure to Update?");
            }
        </script>
    </body>
</html>
