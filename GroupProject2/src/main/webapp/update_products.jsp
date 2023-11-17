<!DOCTYPE html>
<html>
<head>
    <meta charset="BIG5">
    <title>Insert title here</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div style="border: 1px solid black; padding: 10px;">
        <% String table = (String) request.getAttribute("table"); %>
        <%= table %>
    </div>
    
    <div id="update" style="border: 1px solid black; padding: 10px;">
        <form method="post" action="UpdatingProduct">
            Please enter the updated Product information. <br><br>
            ProductID: <input type="text" name="id"/><br><br>
            Product Name: <input type="text" name="name"/><br><br>
            Product Model: <input type="text" name="model"/><br><br>
            
            <input type="submit" name="submit"/>
        </form>
    </div>
    
    <div id="insert" style="border: 1px solid black; padding: 10px;">
        <form method="post" action="InsertingProduct">
            Please enter the new Product information to insert. <br><br>
            ProductID: <input type="text" name="id"/><br><br>
            Product Name: <input type="text" name="name"/><br><br>
            Product Model: <input type="text" name="model"/><br><br>
            
            <input type="submit" name="submit"/>
        </form>
    </div>
    
    <div id="delete" style="border: 1px solid black; padding: 10px;">
        <form method="post" action="DeletingProduct">
            Please enter the Product ID to delete. <br><br>
            ProductID: <input type="text" name="id"/><br><br>   	
            <input type="submit" name="submit"/>
        </form>
    </div>
    
</div>
<a href="dashboard_admin.jsp">Back to Admin Dashboard</a>
</body>
</html>
