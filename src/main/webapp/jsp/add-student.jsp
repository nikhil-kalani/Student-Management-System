<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Add Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="container">
    <h2>Add Student</h2>

    <form method="post" action="${pageContext.request.contextPath}/add-student" class="form">
        <label>Name</label><br/>
        <input type="text" name="name" required /><br/>

        <label>Email</label><br/>
        <input type="email" name="email" required /><br/>

        <label>Phone</label><br/>
        <input type="text" name="phone" /><br/>

        <label>Course</label><br/>
        <input type="text" name="course" /><br/>

        <label>DOB</label><br/>
        <input type="date" name="dob" /><br/>

        <button type="submit">Add</button>
    </form>

    <p class="error">${requestScope.error}</p>

    <p><a href="${pageContext.request.contextPath}/students">← Back to list</a></p>
</div>
</body>
</html>
