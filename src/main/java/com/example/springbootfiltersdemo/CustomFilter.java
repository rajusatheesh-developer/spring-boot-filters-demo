package com.example.springbootfiltersdemo;


import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

//@Component
//@Order(1)
public class CustomFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("Request : "+request.getMethod());
        System.out.println("Response : "+response.getStatus());



        try {
            filterChain.doFilter(request, response);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }



    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
