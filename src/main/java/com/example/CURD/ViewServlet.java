package com.example.CURD;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
//            ResultSet rs=StudentDao.selectAllStudent();
//            response.setContentType("text/html");
//            PrintWriter pw=response.getWriter();
//            pw.print("<table border='1' width='100%>");
//            pw.print("<tr>" + "<th>Id</th><th>Name</th><th>Password</th><th>Email</th></tr>");
//            while(rs.next()){
//                pw.print("<tr><td>" + rs.getInt(1) + "</td><td>"
//                    +  rs.getString(2) + "</td><td>" +
//                        rs.getString(3) + "</td><td>"  +
//                        rs.getString(4) + "</td></tr>"
//                );
//            }
//            pw.print("</table>");
//            pw.close();

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<a href='Form.html'>Add New Student</a>");
            pw.println("<h1>Students List</h1>");

            List<Student> list = StudentDao.selectAllStudents();

            pw.print("<table border='1' width='100%' style='border-collapse:collapse'");
            pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");

            for (Student student : list) {
                pw.print("<tr><td>" + student.getId() + "</td><td>" + student.getStudentName() + "</td><td>" + student.getPassword() +
                        "</td><td>" + student.getEmail() + "</td><td><a href='viewByIdServlet?id=" + student.getId() + "'>edit</a></td>" +
                        "<td><a href='deleteServlet?id=" + student.getId() + "'>delete</a></td></tr>");
            }
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
