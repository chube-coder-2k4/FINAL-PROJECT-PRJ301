<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="model.SalesPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Car</title>
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
                max-width: 500px;
                margin: auto;
                background: white;
                padding: 25px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }
            .form-group input, .form-group select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                transition: 0.3s;
            }
            .form-group input:focus {
                border-color: #007BFF;
                box-shadow: 0px 0px 5px rgba(0, 91, 187, 0.5);
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
                font-size: 16px;
            }
            .form-group-buttons {
                display: flex;
                justify-content: center;
                gap: 15px;
                margin-top: 15px;
            }
            .btn {
                padding: 12px 20px;
                text-decoration: none;
                font-size: 16px;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: 0.3s;
                width: 40%; /* Làm cho nút có độ rộng cân đối */
                text-align: center;
            }
            .btn-submit { background: #28a745; }
            .btn-back { background: #007BFF; }
            .btn:hover {
                opacity: 0.85;
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
            }
        %>

        <div class="container">
            <h1>Create Car</h1>

            <form action="MainServlet" method="post">
                <div class="form-group">
                    <input type="text" id="serialNumber" name="serialNumber" placeholder="Enter serial number" required>
                </div>
                <div class="form-group">
                    <input type="text" id="model" name="model" placeholder="Enter model" required>
                </div>
                <div class="form-group">
                    <input type="text" id="color" name="color" placeholder="Enter color" required>
                </div>
                <div class="form-group">
                    <input type="text" id="year" name="year" placeholder="Enter year" required>
                </div>
                <div class="form-group">
                    <input type="text" id="price" name="price" placeholder="Enter price" required>
                </div>
                <div class="form-group-buttons">
                    <input type="hidden" name="action" value="CREATE_CAR"/>
                    <button type="submit" class="btn btn-submit">Create</button>
                    <a href="MainServlet?action=LOAD_CARS" class="btn btn-back">Back to List</a>
                </div>
            </form>

            <%
                String message = (String) request.getAttribute("MESSAGE");
                if (message != null) {
            %>
            <div class="message <%= message.contains("Complete") ? "success" : "error"%>">
                <%= message%>
            </div>
            <% }%>
        </div>

    </body>
</html>