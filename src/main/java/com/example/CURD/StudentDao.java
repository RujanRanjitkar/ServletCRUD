package com.example.CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentInfo", "postgres", "Rujan123");
        return con;
    }

    public static int insertStudentData(Student student) throws Exception {
        int status;
        Connection con = StudentDao.getConnection();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Student(name,password,email) VALUES (?,?,?)");
        stmt.setString(1, student.getStudentName());
        stmt.setString(2, student.getPassword());
        stmt.setString(3, student.getEmail());
        status = stmt.executeUpdate();

        con.close();
        return status;
    }

//    public static ResultSet selectAllStudent() throws Exception{
//        Connection con=StudentDao.getConnection();
//        PreparedStatement stmt=con.prepareStatement("SELECT * FROM Student");
//        return stmt.executeQuery();
//    }

    public static List<Student> selectAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = StudentDao.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Student");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setStudentName(rs.getString(2));
            student.setEmail(rs.getString(3));
            student.setPassword(rs.getString(4));
            list.add(student);
        }
        con.close();
        return list;
    }

    public static Student selectStudentById(int id) throws Exception {
        Student student = new Student();
        Connection con = StudentDao.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Student WHERE id=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            student.setId(rs.getInt(1));
            student.setStudentName(rs.getString(2));
            student.setEmail(rs.getString(3));
            student.setPassword(rs.getString(4));
        }
        con.close();
        return student;
    }

    public static int updateStudent(Student student) throws Exception {
        int status;
        Connection con = StudentDao.getConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE Student SET name=?, password=?, email=? WHERE id=?");
        stmt.setString(1, student.getStudentName());
        stmt.setString(2, student.getPassword());
        stmt.setString(3, student.getEmail());
        stmt.setInt(4, student.getId());
        status = stmt.executeUpdate();
        con.close();
        return status;
    }

    public static void deleteStudent(int id) throws Exception {
        Connection con = StudentDao.getConnection();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM Student WHERE id=?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
