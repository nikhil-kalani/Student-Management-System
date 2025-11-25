 Student Management System


A simple yet powerful Student Management System built using
Java Servlets, JSP, JDBC, and MySQL
Manage student details with full CRUD functionality.

---

## 📌 Features

- 🔐 Admin login with session authentication
- ➕ Add Student
- 📋 View Student List
- ✏️ Edit Student Details
- ❌ Delete Student
- 🧩 MVC Design Pattern
- 🗄 JDBC CRUD operations
- 🎨 Clean UI using HTML + CSS

---

## 🛠 Technologies Used

| Category | Tech |
|---------|------|
| Language | Java 8+ |
| Backend | Servlets & JSP |
| Database | MySQL |
| JDBC Driver | mysql-connector-j |
| Server | Apache Tomcat 9+ |
| IDE | Eclipse |

---

## 📂 Project Structure

```plaintext
StudentManagementSystem/
├── src/com/example/sms/
│   ├── model/Student.java
│   ├── util/DBUtil.java
│   ├── dao/StudentDAO.java
│   └── servlet/
│       ├── LoginServlet.java
│       ├── LogoutServlet.java
│       ├── StudentListServlet.java
│       ├── AddStudentServlet.java
│       └── EditStudentServlet.java
│
├── WebContent/
│   ├── jsp/
│   │   ├── login.jsp
│   │   ├── students.jsp
│   │   ├── add-student.jsp
│   │   └── edit-student.jsp
│   ├── css/style.css
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/mysql-connector-j.jar
└── README.md
