package com.example.LoginPage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginPage", value = "/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();

//        String name=request.getParameter("Username");
        String password=request.getParameter("Password");

        if(password.equals("Rujan123")){
            RequestDispatcher rd=request.getRequestDispatcher("welcomePage");
            rd.forward(request,response);
        }
        else {
            pw.print("Sorry Username or Password Incorrect!!!");
            RequestDispatcher rd=request.getRequestDispatcher("/LoginForm.html");
            rd.include(request,response);
        }
    }

}
