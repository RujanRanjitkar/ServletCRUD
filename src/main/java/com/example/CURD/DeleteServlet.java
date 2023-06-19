package com.example.CURD;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        try {
            StudentDao.deleteStudent(id);
            response.sendRedirect("viewServlet");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
