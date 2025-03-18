<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #4facfe, #00f2fe);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card shadow-lg">
                    <div class="card-body text-center">
                        <h2 class="mb-3">Login</h2>
                        <form action="MainServlet" method="POST">
                            <div class="mb-3">
                                <input type="text" name="txtname" class="form-control" placeholder="Enter your name" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100" name="action" value="LOGIN">Login</button>
                        </form>
                        <% if (request.getAttribute("ERROR") != null) { %>
                            <p class="text-danger mt-2"><%= request.getAttribute("ERROR") %></p>
                        <% } %>
                        <div class="mt-3">
                            <a href="#" class="d-block text-primary">Login as Mechanic</a>
                            <a href="#" class="d-block text-primary">Login as Customer</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
