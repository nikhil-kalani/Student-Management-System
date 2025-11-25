<%@ page import="java.util.List" %>
<%@ page import="com.example.sms.model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Student List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="container">
    <h2>Student List</h2>

    <div class="top-actions">
        <a class="btn" href="${pageContext.request.contextPath}/add-student">Add New Student</a>
        <a class="btn danger" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>

    <br/>

    <table class="styled-table" width="100%">
        <thead>
            <tr>
                <th style="width:6%;">ID</th>
                <th style="width:20%;">Name</th>
                <th style="width:22%;">Email</th>
                <th style="width:12%;">Phone</th>
                <th style="width:14%;">Course</th>
                <th style="width:12%;">DOB</th>
                <th style="width:14%;">Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) {
                for (Student s : students) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getPhone() %></td>
                <td><%= s.getCourse() %></td>
                <td><%= s.getDob() %></td>
                <td>
                    <a class="action" href="${pageContext.request.contextPath}/edit-student?id=<%= s.getId() %>">Edit</a>
                    |
                    <a class="action danger" href="${pageContext.request.contextPath}/delete-student?id=<%= s.getId() %>" onclick="return confirm('Delete this student?')">Delete</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="7" style="text-align:center; padding:18px 0;">No students found. <a href="${pageContext.request.contextPath}/add-student">Add one</a>.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
