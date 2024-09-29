package org.example;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RequestFilter implements Filter {

    private static final String REQUEST_HEADER_NAME = "x-request-id";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if X-Request-ID header is already present in the request
        String requestId = httpRequest.getHeader(REQUEST_HEADER_NAME);

        // If not present, generate a new request ID
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }

        // Add the X-Request-ID to the response header
        httpResponse.setHeader(REQUEST_HEADER_NAME, requestId);

        // Continue with the next filter in the chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}