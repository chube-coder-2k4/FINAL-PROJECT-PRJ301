<%@page import="java.util.List"%>
<%@page import="model.Cars"%>
<%@page import="model.SalesPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Service Ticket</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 50%;
                margin: 50px auto;
                background: white;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            }
            h2 {
                color: #333;
                border-bottom: 2px solid #2c3e50;
                padding-bottom: 10px;
            }
            form {
                display: flex;
                flex-direction: column;
                gap: 15px;
                align-items: center;
            }
            input, select {
                width: 90%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                text-align: left;
            }
            input[readonly] {
                background-color: #eee;
            }
            button {
                background-color: #2ecc71;
                color: white;
                padding: 12px;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background 0.3s;
                width: 92%;
            }
            button:hover {
                background-color: #27ae60;
            }
            .back-btn {
                display: inline-block;
                margin-top: 20px;
                padding: 12px 20px;
                background-color: #3498db;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                transition: background 0.3s;
            }
            .back-btn:hover {
                background-color: #2980b9;
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
                String custID = request.getParameter("custID");
                if (custID != null) {
                    List<Cars> listCar = (List<Cars>) request.getAttribute("listCar"); // Lấy danh sách xe từ request
        %>
        <div class="container">
            <h2>Create Service Ticket</h2>
            <form action="MainServlet" method="post">
                <input type="date" name="dateReceived" required>
                <input type="date" name="dateReturned" required>

                <label for="carID">Select Car:</label>
                <select name="carID" required>
                    <% if (listCar != null && !listCar.isEmpty()) {
                            for (Cars car : listCar) {%>
                    <option value="<%= car.getCarID()%>"><%= car.getModel()%> - <%= car.getColour()%></option>
                    <%  }
                    } else { %>
                    <option value="">No cars available</option>
                    <% }%>
                </select>

                <input type="text" name="custID" value="<%= custID%>" readonly>
                <input type="hidden" name="action" value="CREATE_SERVICE_TICKET"/> 
                <button type="submit">Submit</button>
            </form>
            <a href="MainServlet?action=LOAD_DETAIL_CUSTOMER&custID=<%=custID%>" class="back-btn">Back to list</a>
            <%
                String message = (String) request.getAttribute("MESSAGE");
                if (message != null) {
            %>
            <div class="message <%= message.contains("Complete") ? "success" : "error"%>">
                <%= message%>
            </div>
            <% } %>
        </div>
        <%
                }
            }
        %>
    </body>
</html>