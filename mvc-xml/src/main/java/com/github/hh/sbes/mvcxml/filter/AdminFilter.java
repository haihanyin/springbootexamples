package com.github.hh.sbes.mvcxml.filter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("adminFilter")
public class AdminFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @PostConstruct
    public void init1() {
        System.out.println("AdminFilter is created.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (requestURI.endsWith("forward")) {
            servletRequest.getRequestDispatcher("/myforward").forward(servletRequest, servletResponse);
            return;
        } else if (requestURI.endsWith("error")){
            ((HttpServletResponse) servletResponse).setStatus(403);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
