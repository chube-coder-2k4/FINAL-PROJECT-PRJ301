<%@page import="model.SalesPerson"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Customers</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <% SalesPerson user = (SalesPerson) session.getAttribute("USER");
            if (user == null) {
                request.setAttribute("ERROR", "You need to login first!");
                request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
            } else {
                List<Customer> customers = (List<Customer>) request.getAttribute("customerList");
                List<Customer> customersFind = (List<Customer>) request.getAttribute("listCustomerSearch");
        %>
        <div class="container mt-5">
            <h1 class="text-center">Manage Customers</h1>
            <hr/>
            <div class="d-flex justify-content-between mb-3">
                <a href="MainServlet?action=DASHBOARD" class="btn btn-primary">Back to Dashboard</a>
                <a href="MainServlet?action=LOGOUT" class="btn btn-secondary">Logout</a>
            </div>
            <form action="MainServlet?action=SEARCH_CUSTOMER" method="post" class="d-flex mb-3">
                <input type="text" name="custName" class="form-control me-2" value="<%= (request.getAttribute("custName") != null) ? request.getAttribute("custName") : ""%>" placeholder="Search Customer By Name">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
            <table class="table table-bordered table-striped text-center">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (customersFind != null) {
                        for (Customer c : customersFind) { %>
                    <tr>
                        <td><%= c.getCustID() %></td>
                        <td><%= c.getCustName() %></td>
                        <td><%= c.getPhone() %></td>
                        <td>
                            <a href="MainServlet?action=EDIT_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-warning btn-sm">Update</a>
                            <a href="MainServlet?action=DELETE_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-danger btn-sm">Delete</a>
                            <a href="MainServlet?action=LOAD_DETAIL_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-info btn-sm">Details</a>
                            <a href="MainServlet?action=INVOICE_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-info btn-sm">Invoice</a>
                        </td>
                    </tr>
                    <%  }
                    } else if (customers != null) {
                        for (Customer c : customers) { %>
                    <tr>
                        <td><%= c.getCustID() %></td>
                        <td><%= c.getCustName() %></td>
                        <td><%= c.getPhone() %></td>
                        <td>
                            <a href="MainServlet?action=EDIT_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-warning btn-sm">Update</a>
                            <a href="MainServlet?action=DELETE_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-danger btn-sm">Delete</a>
                            <a href="MainServlet?action=LOAD_DETAIL_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-info btn-sm">Details</a>
                            <a href="MainServlet?action=INVOICE_CUSTOMER&custID=<%= c.getCustID() %>" class="btn btn-info btn-sm">Invoice</a>
                        </td>
                    </tr>
                    <% } } %>
                </tbody>
            </table>
            <a href="MainServlet?action=REGISTER_CUSTOMER" class="btn btn-success">Create Customer</a>
            <% if (request.getAttribute("SUCCESS") != null) {
                out.print("<div class='alert alert-success mt-3'>" + request.getAttribute("SUCCESS") + "</div>");
            } %>
        </div>
        <% } %>
    </body>
</html>