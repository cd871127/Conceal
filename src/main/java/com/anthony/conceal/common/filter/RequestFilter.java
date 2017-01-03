package com.anthony.conceal.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
@WebFilter(filterName = "requestFilter", urlPatterns = {"*.do", "*.jsp"})
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String[] url = httpRequest.getRequestURI().split("/");
        String doName = url[url.length - 1];
        HttpSession session = httpRequest.getSession();
        if ("login.do".equalsIgnoreCase(doName) ||
                "register.do".equalsIgnoreCase(doName) ||
                "index.jsp".equalsIgnoreCase(doName) ||
                "register.jsp".equalsIgnoreCase(doName) ||
                null != session.getAttribute("userDTO")) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
