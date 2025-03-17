<%@page import="model.Cars"%>
<%@page import="model.SalesPerson"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Car</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                width: 100%;
                max-width: 500px;
                background: white;
                padding: 20px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
                text-align: center;
            }
            h1 {
                margin-bottom: 15px;
                color: #333;
            }
            .form-group {
                margin-bottom: 15px;
                text-align: left;
            }
            .form-group label {
                font-weight: bold;
                margin-bottom: 5px;
                display: block;
            }
            .form-group input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
                font-size: 14px;
            }
            .radio-group {
                display: flex;
                justify-content: center;
                gap: 20px;
                margin-top: 5px;
            }
            .radio-group label {
                display: flex;
                align-items: center;
                gap: 5px;
            }
            .btn-container {
                display: flex;
                justify-content: center;
                gap: 15px;
                margin-top: 10px;
            }
            .btn {
                padding: 10px 20px;
                text-decoration: none;
                color: white;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: 0.3s;
                border: none;
            }
            .btn-submit {
                background: green;
            }
            .btn-submit:hover {
                background: darkgreen;
            }
            .btn-back {
                background: #007BFF;
            }
            .btn-back:hover {
                background: #0056b3;
            }
            .message {
                margin-top: 15px;
                font-size: 14px;
                font-weight: bold;
                padding: 10px;
                border-radius: 5px;
                text-align: center;
            }
            .success {
                color: green;
                background: #eaf7ea;
                border: 1px solid green;
            }
            .error {
                color: red;
                background: #fdeaea;
                border: 1px solid red;
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
                Cars car = (Cars) request.getAttribute("car");
        %>

        <div class="container">
            <h1>Update Car</h1>

            <form action="MainServlet" method="post">
                <div class="form-group">
                    <label for="carID">ID:</label>
                    <input type="text" id="carID" name="carID" value="<%= car.getCarID()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="serialNumber">Serial Number:</label>
                    <input type="text" id="serialNumber" name="serialNumber" value="<%= car.getSerialNumber()%>" placeholder="Enter serial number" required>
                </div>
                <div class="form-group">
                    <label for="model">Model:</label>
                    <input type="text" id="model" name="model" value="<%= car.getModel()%>" placeholder="Enter model" required>
                </div>
                <div class="form-group">
                    <label for="Color">Color:</label>
                    <input type="text" id="color" name="color" value="<%= car.getColour()%>" placeholder="Enter color" required>
                </div>
                <div class="form-group">
                    <label for="Year">Year</label>
                    <input type="text" id="year" name="year" value="<%= car.getYear()%>" placeholder="Enter year" required>
                </div>
                <div class="form-group">
                    <label for="Price">Price</label>
                    <input type="text" id="price" name="price" value="<%= car.getPrice()%>" placeholder="Enter price" required>
                </div>
                <input type="hidden" value="UPDATE_CAR" name="action">

                <div class="btn-container">
                    <button type="submit" class="btn btn-submit">Update</button>
                    <a href="MainServlet?action=LOAD_CARS" class="btn btn-back">Back to Dashboard</a>
                </div>
            </form>

            <%
                String message = (String) request.getAttribute("MESSAGE");
                if (message != null) {
            %>
            <div class="message <%= message.contains("Complete") ? "success" : "error"%>">
                <%= message%>
            </div>
            <% } %>
        </div>

        <% }%>
    </body>
</html>
