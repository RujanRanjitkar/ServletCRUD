package com.example.CURD;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("Username");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");

        Student student = new Student(id, name, password, email);

        try {
            int status = StudentDao.updateStudent(student);
            if (status > 0)
                response.sendRedirect("viewServlet");
            else
                pw.println("Unable to update record");

            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
