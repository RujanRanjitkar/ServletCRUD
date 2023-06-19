package com.example.CURD;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/viewByIdServlet")
public class ViewByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>Update Student</h1>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        try {
            Student student = StudentDao.selectStudentById(id);
            pw.print("<form action='updateServlet' method='post'>");
            pw.print("<table>");
            pw.print("<tr><td></td><td><input type='hidden' name='id' value='" + student.getId() + "'/></td></tr>");
            pw.print("<tr><td>Name:</td><td><input type='text' name='Username' value='" + student.getStudentName() + "'/></td></tr>");
            pw.print("<tr><td>Password:</td><td><input type='password' name='Password' value='" + student.getPassword() + "'/></td></tr>");
            pw.print("<tr><td>Email:</td><td><input type='email' name='Email' value='" + student.getEmail() + "'/></td></tr>");
            pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
            pw.print("</table>");
            pw.print("</form>");
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
