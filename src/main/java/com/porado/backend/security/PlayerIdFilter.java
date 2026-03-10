package com.porado.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class PlayerIdFilter extends OncePerRequestFilter {

    public static final String HEADER_NAME = "X-Guest-ID";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String guestId = request.getHeader(HEADER_NAME);

        if (guestId == null || guestId.isBlank()) {
            guestId = UUID.randomUUID().toString();
        }

        request.setAttribute("guestId", guestId);

        response.setHeader(HEADER_NAME, guestId);

        filterChain.doFilter(request, response);
    }
}
