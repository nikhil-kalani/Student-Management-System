<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="container">
    <h2>Admin Login</h2>

    <form method="post" action="${pageContext.request.contextPath}/login" class="form">
        <label>Username</label><br/>
        <input type="text" name="username" required /><br/>

        <label>Password</label><br/>
        <input type="password" name="password" required /><br/>

        <button type="submit">Login</button>
    </form>

    <c:if test="${not empty requestScope.error}">
        <p class="error">${requestScope.error}</p>
    </c:if>
</div>
</body>
</html>
