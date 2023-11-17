<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <header>
        <h1>Welcome to the Admin Dashboard</h1>
    </header>
    <nav>
        <ul>
            <li><a href="display_users">View Users</a></li>
            <li><a href="display_registered_products">View Registered Products</a></li>
            <li><a href="display_claims">View Claims</a></li>
            <li><a href="update_products">Update Products</a></li>
            <li><a href="viewReport">View Report</a></li>
        </ul>
    </nav>
    <a href="logout.jsp">Logout</a>
    <main>
        <h2>Overview</h2>
        <p>
            This is the admin dashboard, where you can manage various aspects of the system. 
            Use the navigation links above to access different functionalities.
        </p>
    </main>
    <footer>
        <p>&copy; 2023 Admin Dashboard</p>
    </footer>
</div>
</body>
</html>
