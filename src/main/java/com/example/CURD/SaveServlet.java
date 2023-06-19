package com.example.CURD;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("Username");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");

        Student student = new Student(name, password, email);

        try {
            int status = StudentDao.insertStudentData(student);
            if (status > 0) {
                pw.print("Record saved successfully");
                request.getRequestDispatcher("Form.html").include(request, response);
            } else {
                pw.print("Unable to save record");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pw.close();

    }
}
