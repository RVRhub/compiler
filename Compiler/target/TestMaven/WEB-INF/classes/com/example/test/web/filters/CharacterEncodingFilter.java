package com.example.test.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        } catch (Exception e) {

        }
    }

    @Override
    public void destroy() {
    }
}