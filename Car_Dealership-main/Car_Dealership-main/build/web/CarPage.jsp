<%@page import="model.Cars"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SalesPerson"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Car</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                background-color: #f8f9fa;
                color: #333;
            }
            h1 {
                text-align: center;
                color: #007BFF;
            }
            .container {
                max-width: 900px;
                margin: auto;
                background: white;
                padding: 20px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }
            .header-buttons {
                display: flex;
                justify-content: space-between;
                margin-bottom: 20px;
            }
            .btn {
                padding: 8px 15px;
                text-decoration: none;
                color: white;
                border-radius: 5px;
                font-weight: bold;
                transition: 0.3s;
            }
            .btn:hover {
                opacity: 0.8;
            }
            .btn-create { background: #28a745; }
            .btn-update { background: #ffc107; }
            .btn-delete { background: #dc3545; }
            .btn-info { background: #17a2b8; }
            .btn-back { background: #007BFF; }
            .btn-logout { background: #6c757d; }

            /* Tìm kiếm */
            .search-container {
                display: flex;
                justify-content: center;
                margin-bottom: 20px;
            }
            .search-container input {
                padding: 10px;
                width: 350px;
                border: 2px solid #007BFF;
                border-radius: 5px;
                font-size: 16px;
                outline: none;
                transition: 0.3s;
            }
            .search-container input:focus {
                border-color: #0056b3;
                box-shadow: 0px 0px 5px rgba(0, 91, 187, 0.5);
            }
            .search-container button {
                padding: 10px 15px;
                background: #007BFF;
                color: white;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                margin-left: 5px;
                transition: 0.3s;
            }
            .search-container button:hover {
                background: #0056b3;
            }

            /* Bảng */
            table {
                width: 100%;
                border-collapse: collapse;
                background: white;
                border-radius: 8px;
                overflow: hidden;
                box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
            }
            th, td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: center;
            }
            th {
                background-color: #007BFF;
                color: white;
            }
            tr:hover {
                background-color: #f1f1f1;
            }

            /* Nút Create Car */
            .create-customer-container {
                margin-top: 15px;
                display: flex;
                justify-content: flex-start;
            }

        </style>
    </head>
    <body>
        <%
            SalesPerson user = (SalesPerson) session.getAttribute("USER");
            if (user == null) {
                request.setAttribute("ERROR", "You need to login first!");
                request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
            } else {
                ArrayList<Cars> cars = (ArrayList<Cars>) request.getAttribute("carList"); // Lấy danh sách khách hàng
                ArrayList<Cars> carsFind = (ArrayList<Cars>) request.getAttribute("listCarSearch");
        %>

        <div class="container">
            <h1>Manage Cars</h1>

            <div class="header-buttons">
                <a href="MainServlet?action=DASHBOARD" class="btn btn-back">Back to Dashboard</a>
                <a href="MainServlet?action=LOGOUT" class="btn btn-logout">Logout</a>
            </div>

            <!-- Thanh tìm kiếm -->
            <div class="search-container">
                <form action="MainServlet?action=SEARCH_CAR" method="post">
                    <input type="text" name="txtFind" value="<%= (request.getAttribute("txtFind") != null) ? request.getAttribute("txtFind") : ""%>" placeholder="Search Car By Serial Number, Model or Year" >
                    <button type="submit">Search</button>
                </form>
            </div>

            <!-- Bảng hiển thị danh sách xe -->

            <table>
                <tr>
                    <th>ID</th>
                    <th>Serial Number</th>
                    <th>Model</th>
                    <th>Color</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <% if (carsFind != null) {
                        for (Cars c : carsFind) {%>
                <tr>
                    <td><%= c.getCarID()%></td>
                    <td><%= c.getSerialNumber()%></td>
                    <td><%= c.getModel()%></td>
                    <td><%= c.getColour()%></td>
                    <td><%= c.getYear()%></td>
                    <td><%= c.getPrice()%></td>
                    <td>
                        <a href="MainServlet?action=EDIT_CAR&carID=<%= c.getCarID()%>" class="btn btn-update">Update</a>
                        <a href="MainServlet?action=DELETE_CAR&carID=<%= c.getCarID()%>" class="btn btn-delete">Delete</a>
<!--                        <a href="#" class="btn btn-info">Details</a>-->
                    </td>
                </tr>
                <%  }
                } else if (cars != null)
                    for (Cars c : cars) {%>
                <tr>
                    <td><%= c.getCarID()%></td>
                    <td><%= c.getSerialNumber()%></td>
                    <td><%= c.getModel()%></td>
                    <td><%= c.getColour()%></td>
                    <td><%= c.getYear()%></td>
                    <td><%= c.getPrice()%></td>
                    <td>
                        <a href="MainServlet?action=EDIT_CAR&carID=<%= c.getCarID()%>" class="btn btn-update">Update</a>
                        <a href="MainServlet?action=DELETE_CAR&carID=<%= c.getCarID()%>" class="btn btn-delete">Delete</a>
                    </td>
                </tr>
                <% } %>
            </table>

            <!-- Nút Create Cars ở góc dưới bên trái -->
            <div class="create-customer-container">
                <a href="MainServlet?action=REGISTER_CAR" class="btn btn-create">Create Car</a>
            </div>

            <!-- Thông báo -->
            <% if (request.getAttribute("MESSAGE") != null) {
                    out.print("<p style='color:green;'>" + request.getAttribute("MESSAGE") + "</p>"); %> 
            <% } %>
        </div>
        <% }%>
    </body>
</html>