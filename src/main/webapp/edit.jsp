<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            color: #0056b3;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<div class="container">

    <h1>User Details</h1>

    <p>
        <strong>Name:</strong>
        <jsp:getProperty property="name" name="stu"/>
    </p>
    <p>
        <strong>Password:</strong>
        <jsp:getProperty property="possword" name="stu"/>
    </p>
    <p>
        <strong>Item:</strong>
        <jsp:getProperty property="item" name="stu"/>
    </p>
    <p>
        <strong>Quantity:</strong>
        <jsp:getProperty property="quantity" name="stu"/>
    </p>

    <table border="1">
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="student">
            <tr>
                <td><c:out value="${stu.item}"/></td>
                <td><jsp:getProperty property="quantity" name="stu"/></td>
                <td><a href="edit.jsp"?item=>Edit</a></td>
                <td><a href="delete.jsp"?item=>Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
