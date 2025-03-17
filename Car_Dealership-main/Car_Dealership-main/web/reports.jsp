<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Reports</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${empty sessionScope.USER}">
            <c:set var="ERROR" value="You need to login first!" scope="request"/>
            <jsp:forward page="MainServlet?action=HOME"/>
        </c:if>
        <div class="container mt-4">
            <h2 class="text-center">Reports</h2>

            <h3 class="mt-4">Cars Sold by Year</h3>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr><th>Year</th><th>Cars Sold</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.carsSoldByYear}">
                        <tr><td>${row.year}</td><td>${row.carsSold}</td></tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3 class="mt-4">Car Sales Revenue by Year</h3>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr><th>Year</th><th>Total Revenue</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.revenueByYear}">
                        <tr><td>${row.year}</td><td>${row.totalRevenue}</td></tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3 class="mt-4">Best-Selling Car Models</h3>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr><th>Model</th><th>Sales Count</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.bestSellingModels}">
                        <tr><td>${row.model}</td><td>${row.salesCount}</td></tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3 class="mt-4">Best Used Parts</h3>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr><th>Part Name</th><th>Total Used</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.bestUsedParts}">
                        <tr><td>${row.partName}</td><td>${row.totalUsed}</td></tr>
                    </c:forEach>
                </tbody>
            </table>

            <h3 class="mt-4">Top 3 Mechanics by Repairs</h3>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr><th>Mechanic Name</th><th>Repair Count</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.topMechanics}">
                        <tr><td>${row.mechanicName}</td><td>${row.repairCount}</td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>