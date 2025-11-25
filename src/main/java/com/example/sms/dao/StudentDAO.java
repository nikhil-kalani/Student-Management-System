package com.example.sms.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.sms.dao.*;
import com.example.sms.model.Student;
import com.example.sms.util.*;

public class StudentDAO {


// list all students
public List<Student> getAllStudents() {
	List<Student> students = new ArrayList<>();
	String sql = "SELECT * FROM students ORDER BY id DESC";
	try (Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {


while (rs.next()) {
	Student s = new Student(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("email"),
			rs.getString("phone"),
			rs.getString("course"),
			rs.getDate("dob")
			);
		students.add(s);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
	return students;
}


//add student
public boolean addStudent(Student s) {
	String sql = "INSERT INTO students(name, email, phone, course, dob) VALUES(?,?,?,?,?)";
	try (Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail());
		ps.setString(3, s.getPhone());
		ps.setString(4, s.getCourse());
		ps.setDate(5, s.getDob());
		return ps.executeUpdate() > 0;
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return false;
}



//get by id
public Student getStudentById(int id) {
	String sql = "SELECT * FROM students WHERE id=?";
	try (Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setInt(1, id);
		try (ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return new Student(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("course"),
						rs.getDate("dob")
						);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}



//update
public boolean updateStudent(Student s) {
	String sql = "UPDATE students SET name=?, email=?, phone=?, course=?, dob=? WHERE id=?";
	try (Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail());
		ps.setString(3, s.getPhone());
		ps.setString(4, s.getCourse());
		ps.setDate(5, s.getDob());
		ps.setInt(6, s.getId());
		return ps.executeUpdate() > 0;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}


//delete
public boolean deleteStudent(int id) {
	String sql = "DELETE FROM students WHERE id=?";
	try (Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	} catch (SQLException e) {
		e.printStackTrace();
}
	return false;
	}
}
