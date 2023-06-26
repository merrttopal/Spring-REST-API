package com.works.configs;


import com.works.Models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;


        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }

        String freeUrls[]= {"/admin/login"};
        String url = req.getRequestURI();

        boolean loginStatus = true;

        for(String item :freeUrls){
            if (url.equals(item)){
                loginStatus = false;
                break;
            }
        }
        if (loginStatus){
            boolean status = req.getSession().getAttribute("user") == null ;
            if (status){
                PrintWriter printWriter = res.getWriter();
                printWriter.println("Please Login!");
                res.setStatus(401);
            }else {
                Admin admin = (Admin) req.getSession().getAttribute("admin");
                req.setAttribute("admin", admin);
                filterChain.doFilter(req,res);
            }
        }
        else {
            filterChain.doFilter(req,res);
        }

    }
}
