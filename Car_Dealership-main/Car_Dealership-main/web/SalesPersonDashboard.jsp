<%@page import="model.SalesPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SalesPerson Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #007bff, #00c6ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .dashboard {
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 400px;
            animation: fadeIn 0.5s ease-in-out;
        }
        h1, h2 {
            color: #333;
        }
        .menu {
            margin-top: 20px;
        }
        .menu a {
            display: block;
            padding: 12px;
            margin: 10px 0;
            background: linear-gradient(135deg, #007bff, #0056b3);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: transform 0.3s, background 0.3s;
        }
        .menu a:hover {
            background: linear-gradient(135deg, #0056b3, #004494);
            transform: scale(1.05);
        }
        .logout {
            margin-top: 20px;
            display: inline-block;
            padding: 12px 20px;
            background: linear-gradient(135deg, #dc3545, #c82333);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: transform 0.3s, background 0.3s;
        }
        .logout:hover {
            background: linear-gradient(135deg, #c82333, #a71d2a);
            transform: scale(1.05);
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
    <% SalesPerson user = (SalesPerson) session.getAttribute("USER");
       if (user == null) {
           request.setAttribute("ERROR", "You need to login first!");
           request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
       } else { %>
    <div class="dashboard">
        <h1>Welcome, <%= user.getSalesName() %>!</h1>
        <a class="logout" href="MainServlet?action=LOGOUT">Logout</a>
        <h2>DASHBOARD</h2>
        <div class="menu">
            <a href="MainServlet?action=LOAD_CUSTOMER">Manage Customers</a>
            <a href="MainServlet?action=LOAD_CARS">Manage Cars</a>
            <a href="MainServlet?action=LOAD_PARTS">Manage Parts</a>
            <a href="ReportServlet">Reports</a>
        </div>
    </div>
    <% } %>
</body>
</html>
