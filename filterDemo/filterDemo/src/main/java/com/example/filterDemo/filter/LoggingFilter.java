package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
// the request logging
        System.out.println("Incoming request" + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);
//  the response
        System.out.println("Outgoing request" + req.getMethod() + " " + req.getRequestURI());

    }
}
