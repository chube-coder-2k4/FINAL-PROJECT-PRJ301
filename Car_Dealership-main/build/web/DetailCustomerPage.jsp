<%@page import="model.ServiceTicket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@page import="model.SalesPerson"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #eef2f7;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 90%;
            max-width: 900px;
            background: white;
            padding: 25px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h2 {
            color: #333;
            border-bottom: 3px solid #007BFF;
            padding-bottom: 8px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .btn-container {
            display: flex;
            gap: 10px;
        }
        .btn {
            display: inline-block;
            padding: 10px 15px;
            text-decoration: none;
            color: white;
            background-color: #28a745;
            border-radius: 5px;
            transition: background 0.3s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .no-tickets {
            text-align: center;
            font-style: italic;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="container">
        <% SalesPerson user = (SalesPerson) session.getAttribute("USER");
           if (user == null) {
               request.setAttribute("ERROR", "You need to login first!");
               request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
           } else {
               Customer customer = (Customer) request.getAttribute("customer");
               ArrayList<ServiceTicket> list = (ArrayList<ServiceTicket>) request.getAttribute("listTicket");
        %>
        <h2>Customer Details</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Sex</th>
                <th>Address</th>
            </tr>
            <tr>
                <td><%= customer.getCustID() %></td>
                <td><%= customer.getCustName() %></td>
                <td><%= customer.getPhone() %></td>
                <td><%= customer.getSex() %></td>
                <td><%= customer.getCusAddress() %></td>
            </tr>
        </table>
        
        <h2>Service Tickets</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Date Received</th>
                <th>Date Returned</th>
                <th>Car ID</th>
            </tr>
            <% if (!list.isEmpty()) {
                for (ServiceTicket ticket : list) { %>
            <tr>
                <td><%= ticket.getTicketID() %></td>
                <td><%= ticket.getDateReceived() %></td>
                <td><%= ticket.getDateReturned() %></td>
                <td><%= ticket.getCarID() %></td>
            </tr>
            <% } } else { %>
            <tr>
                <td colspan="4" class="no-tickets">No Service Tickets Found</td>
            </tr>
            <% } %>
        </table>
        
        <div class="btn-container">
            <a href="MainServlet?action=LOAD_CUSTOMER" class="btn">Back to List</a>
            <a href="MainServlet?action=LOAD_CREATE_TICKET&custID=<%=customer.getCustID()%>" class="btn">Create Ticket</a>
        </div>
        <% } %>
    </div>
</body>
</html>
