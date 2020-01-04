<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings"%>

<html>
<head>
    <title>ToDo Item</title>
</head>
<body>
    <div align="center">

        <table border="1" cellpadding="5">
            <caption><h2>ToDo Items</h2></caption>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Details</th>
                <th>Deadline</th>
            </tr>
            <tr>
                <td>${toDoItem.id}</td>
                <td>${toDoItem.title}</td>
                <td>${toDoItem.details}</td>
                <td>${toDoItem.deadline}</td>
            </tr>
        </table>

        <table>
            <tr>
                <td><label>ID</label></td>
                <td>${toDoItem.id}</td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td>${toDoItem.title}</td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td>${toDoItem.details}</td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td>${toDoItem.deadline}</td>
            </tr>
        </table>

        <c:url var="itemsLink" value="${Mappings.ITEMS}" />
        <a href="${itemsLink}">Show ToDo Items</a>
    </div>
</body>
</html>