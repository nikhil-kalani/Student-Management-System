<%@ page import="com.example.sms.model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Edit Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="container">
    <h2>Edit Student</h2>

    <%
        Student s = (Student) request.getAttribute("student");
        if (s == null) {
    %>
        <p>Student not found.</p>
        <p><a href="${pageContext.request.contextPath}/students">Back to list</a></p>
    <%
        } else {
    %>

    <form method="post" action="${pageContext.request.contextPath}/edit-student" class="form">
        <input type="hidden" name="id" value="<%= s.getId() %>" />

        <label>Name</label><br/>
        <input type="text" name="name" required value="<%= s.getName() != null ? s.getName() : "" %>" /><br/>

        <label>Email</label><br/>
        <input type="email" name="email" required value="<%= s.getEmail() != null ? s.getEmail() : "" %>" /><br/>

        <label>Phone</label><br/>
        <input type="text" name="phone" value="<%= s.getPhone() != null ? s.getPhone() : "" %>" /><br/>

        <label>Course</label><br/>
        <input type="text" name="course" value="<%= s.getCourse() != null ? s.getCourse() : "" %>" /><br/>

        <label>DOB</label><br/>
        <input type="date" name="dob" value="<%= s.getDob() != null ? s.getDob().toString() : "" %>" /><br/>

        <button type="submit">Update</button>
    </form>

    <p class="error">${requestScope.error}</p>

    <p><a href="${pageContext.request.contextPath}/students">← Back to list</a></p>

    <%
        }
    %>
</div>
</body>
</html>
