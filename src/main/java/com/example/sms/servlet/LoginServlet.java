package com.example.sms.servlet;


import com.example.sms.util.DBUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("password");


	String sql = "SELECT * FROM admin WHERE username=? AND password=?";
try (Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
    System.out.println("DB Connection OK inside servlet");

	ps.setString(1, username);
	ps.setString(2, password);
try (ResultSet rs = ps.executeQuery()) {
	if (rs.next()) {
		HttpSession session = req.getSession();
		session.setAttribute("adminUser", username);
		resp.sendRedirect("students");
		return;
	}
}
} catch (Exception e) {
	e.printStackTrace();
}
	req.setAttribute("error", "Invalid username or password");
	req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
}
}
