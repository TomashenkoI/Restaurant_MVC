<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table style="align-items: center;">

    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Position</th>
        <th>Phone Number</th>
        <th>Salary</th>
    </tr>

        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.position}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.salary}</td>
        </tr>

    <c:set var="employee" value="employee"/>

    <form action="/employees/" method="get">
        <button style="background-color: red; height: 25px; width: 100px" value="Удалить сотрудника"/>
    </form>

</table>

</body>
</html>
