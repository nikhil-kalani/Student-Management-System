package com.example.sms.servlet;

import com.example.sms.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Check if admin is logged in
        if (req.getSession().getAttribute("adminUser") == null) {
            resp.sendRedirect("jsp/login.jsp");
            return;
        }

        req.setAttribute("students", dao.getAllStudents());
        req.getRequestDispatcher("jsp/students.jsp").forward(req, resp);
    }
}
