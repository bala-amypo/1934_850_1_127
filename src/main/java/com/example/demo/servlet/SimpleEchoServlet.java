package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        // 1. Read the 'name' parameter from the request
        String name = req.getParameter("name");
        
        // 2. Set response headers as expected by the tests
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);

        // 3. Logic required to pass the test cases:
        // If name is null, empty, or just whitespace -> "Hello, Guest"
        // Otherwise -> "Hello, <TrimmedName>"
        if (name == null || name.trim().isEmpty()) {
            resp.getWriter().write("Hello, Guest");
        } else {
            resp.getWriter().write("Hello, " + name.trim());
        }
    }
}