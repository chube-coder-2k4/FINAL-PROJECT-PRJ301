<%@page import="model.Cars"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SalesPerson"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage Car</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <% SalesPerson user = (SalesPerson) session.getAttribute("USER");
           if (user == null) {
               request.setAttribute("ERROR", "You need to login first!");
               request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
           } else {
               ArrayList<Cars> cars = (ArrayList<Cars>) request.getAttribute("carList");
               ArrayList<Cars> carsFind = (ArrayList<Cars>) request.getAttribute("listCarSearch");
        %>

        <div class="container py-4">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h1 class="text-primary">Manage Cars</h1>
                <div>
                    <a href="MainServlet?action=DASHBOARD" class="btn btn-primary">Back to Dashboard</a>
                    <a href="MainServlet?action=LOGOUT" class="btn btn-secondary">Logout</a>
                </div>
            </div>
            
            <!-- Search Bar -->
            <form action="MainServlet?action=SEARCH_CAR" method="post" class="input-group mb-3">
                <input type="text" name="txtFind" class="form-control" placeholder="Search Car By Serial Number, Model or Year" value="<%= (request.getAttribute("txtFind") != null) ? request.getAttribute("txtFind") : ""%>">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
            
            <!-- Car List Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="table-primary">
                        <tr>
                            <th>ID</th>
                            <th>Serial Number</th>
                            <th>Model</th>
                            <th>Color</th>
                            <th>Year</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (carsFind != null) {
                               for (Cars c : carsFind) { %>
                        <tr>
                            <td><%= c.getCarID() %></td>
                            <td><%= c.getSerialNumber() %></td>
                            <td><%= c.getModel() %></td>
                            <td><%= c.getColour() %></td>
                            <td><%= c.getYear() %></td>
                            <td><%= c.getPrice() %></td>
                            <td>
                                <a href="MainServlet?action=EDIT_CAR&carID=<%= c.getCarID() %>" class="btn btn-warning btn-sm">Update</a>
                                <a href="MainServlet?action=DELETE_CAR&carID=<%= c.getCarID() %>" class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                        <%   }
                           } else if (cars != null) {
                               for (Cars c : cars) { %>
                        <tr>
                            <td><%= c.getCarID() %></td>
                            <td><%= c.getSerialNumber() %></td>
                            <td><%= c.getModel() %></td>
                            <td><%= c.getColour() %></td>
                            <td><%= c.getYear() %></td>
                            <td><%= c.getPrice() %></td>
                            <td>
                                <a href="MainServlet?action=EDIT_CAR&carID=<%= c.getCarID() %>" class="btn btn-warning btn-sm">Update</a>
                                <a href="MainServlet?action=DELETE_CAR&carID=<%= c.getCarID() %>" class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                        <%   }
                           } %>
                    </tbody>
                </table>
            </div>
            
            <!-- Create Car Button -->
            <a href="MainServlet?action=REGISTER_CAR" class="btn btn-success">Create Car</a>
            
            <!-- Notification Message -->
            <% if (request.getAttribute("MESSAGE") != null) { %>
                <div class="alert alert-success mt-3" role="alert">
                    <%= request.getAttribute("MESSAGE") %>
                </div>
            <% } %>
        </div>
        <% } %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
