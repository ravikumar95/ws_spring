package com.app;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class XssFilter implements Filter {
   @Override
   public void destroy() {}

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {
      
      System.out.println("Remote Host:"+request.getRemoteHost());
      System.out.println("Remote Address:"+request.getRemoteAddr());
      System.out.println(request.getParameter("txt_name"));
      
       Enumeration<String> enu= ((HttpServletRequest) request).getParameterNames();
      
       while (enu.hasMoreElements()) {
    	    String param = enu.nextElement();
    	    System.out.println("Enu Params:"+param);
    	}


       filterchain.doFilter(new XSSRequestWrapper((HttpServletRequest) request) , response);
       System.out.println("After Filter:"+ request.getParameter("txt_name"));
      }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {}
}