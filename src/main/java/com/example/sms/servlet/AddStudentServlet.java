package com.example.sms.servlet;

import com.example.sms.dao.StudentDAO;
import com.example.sms.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("adminUser") == null) {
            resp.sendRedirect("jsp/login.jsp");
            return;
        }

        req.getRequestDispatcher("jsp/add-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String course = req.getParameter("course");
        String dobStr = req.getParameter("dob");

        Date dob = null;
        if (dobStr != null && !dobStr.isEmpty()) {
            dob = Date.valueOf(dobStr);
        }

        Student s = new Student(0, dobStr, dobStr, dobStr, dobStr, dob);
        s.setName(name);
        s.setEmail(email);
        s.setPhone(phone);
        s.setCourse(course);
        s.setDob(dob);

        boolean saved = dao.addStudent(s);

        if (saved) {
            resp.sendRedirect("students");
        } else {
            req.setAttribute("error", "Failed to add student.");
            req.getRequestDispatcher("jsp/add-student.jsp").forward(req, resp);
        }
    }
}
