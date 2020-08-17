package com.sarkariblackboard.Configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCustomInterceptor implements HandlerInterceptor {

@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    System.out.println("WELCOME TO SARKARI DASHBOARD");
        return true;
    }

}