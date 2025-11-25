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

@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("adminUser") == null) {
            resp.sendRedirect("jsp/login.jsp");
            return;
        }

        String idStr = req.getParameter("id");

        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Student s = dao.getStudentById(id);

            req.setAttribute("student", s);
            req.getRequestDispatcher("jsp/edit-student.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect("students");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String course = req.getParameter("course");
        String dobStr = req.getParameter("dob");

        Date dob = (dobStr != null && !dobStr.isEmpty()) ? Date.valueOf(dobStr) : null;

        Student s = new Student(id, name, email, phone, course, dob);

        boolean updated = dao.updateStudent(s);

        if (updated) {
            resp.sendRedirect("students");
        } else {
            req.setAttribute("error", "Failed to update student.");
            req.setAttribute("student", s);
            req.getRequestDispatcher("jsp/edit-student.jsp").forward(req, resp);
        }
    }
}
