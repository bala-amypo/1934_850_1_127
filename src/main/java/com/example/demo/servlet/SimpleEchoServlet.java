package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleEchoServlet", urlPatterns = "/echo")
public class SimpleEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        String message = request.getParameter("msg");

        if (message == null || message.isEmpty()) {
            message = "Hello from SimpleEchoServlet";
        }

        out.println("Echo: " + message);
    }
}
