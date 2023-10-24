package com.ndh.hotrohoctap.filters;


import com.ndh.hotrohoctap.components.JwtTokenUtils;
import com.ndh.hotrohoctap.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    @Value("${api.prefix}")
    private String apiPrefix;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtils jwtTokenUtil;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
            // method kiem tra ( CUNG CAP DIEU KIEN KIEM TRA )

        try {
            if(isBypassToken(request) || request.equals("/")) {
                filterChain.doFilter(request, response); //enable bypass
                return;
            }
            final String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized11 ");
                return;
            }
            final String token = authHeader.substring(7);
            final String username =  jwtTokenUtil.extractUsername(token);
            if (username != null
                    && SecurityContextHolder.getContext().getAuthentication() == null) {
                User userDetails = (User) userDetailsService.loadUserByUsername(username);
                if(jwtTokenUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(request, response); //enable bypass
        }catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized ko dc phan quyen");
        }

    }
    // kiem tra tung request va loc

    private boolean isBypassToken(@NonNull HttpServletRequest request) {
        final List<Pair<String, String>> bypassTokens = Arrays.asList(
                Pair.of(String.format("%s/monhoc", apiPrefix), "GET"),
                Pair.of(String.format("%s/giangvien", apiPrefix), "GET"),
                Pair.of(String.format("%s/users/register", apiPrefix), "POST"),
                Pair.of(String.format("%s/users/login", apiPrefix), "POST"),
                Pair.of(String.format("%s/baiTap", apiPrefix), "GET"),
                Pair.of(String.format("%s/baiTap", apiPrefix), "POST"),
                Pair.of(String.format("%s/baiTap", apiPrefix), "PUT"),
                Pair.of(String.format("%s/thongbao", apiPrefix), "GET"),
                Pair.of(String.format("%s/thongbao", apiPrefix), "POST")

        );
        String requestPath = request.getServletPath();
        String requestMethod = request.getMethod();

        if (requestPath.equals("/")
                && requestMethod.equals("GET") ) {
            // Allow access to %s/orders
            return true;
        } if (requestPath.equals("/")
                && requestMethod.equals("POST") ) {
            return true;
        }
        if (requestPath.equals("/api/v1/sendmail")
                && requestMethod.equals("GET") ) {
            // Allow access to %s/orders
            return true;
        }

        if (requestPath.equals("/login")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/api/v1/pdf")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/api/v1/pdf/nguoidung")
                && requestMethod.equals("GET") ) {
            return true;
        } if (requestPath.equals("/api/v1/pdf/diem")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/api/v1/diemMonHoc/**")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/api/v1/diemMonHoc/lessThan5")
                && requestMethod.equals("GET") ) {
            return true;
        } if (requestPath.equals("/api/v1/diemMonHoc/greaterThan8")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/trangchu")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/quanlydiem")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/nguoidung")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/nguoidung/**")
                && requestMethod.equals("PUT") ) {
            // Allow access to %s/orders
            return true;
        }
        if (requestPath.equals("/admin/quanlybaitap")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/quanlymonhoc")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/quanlybaitap/searchBaiTap**")
                && requestMethod.equals("GET") ) {
            return true;
        }
        if (requestPath.equals("/admin/quanlybaitap/searchBaiTap")
                && requestMethod.equals("GET") ) {
            return true;
        }

        if (requestPath.equals("/admin/**")
                && requestMethod.equals("GET") ) {

            return true;
        }
        if (requestPath.equals("/admin/thongke")
                && requestMethod.equals("GET") ) {

            return true;
        }


        for (Pair<String, String> bypassToken : bypassTokens) {
            if(request.getServletPath().contains(bypassToken.getFirst())
                && request.getMethod().equals(bypassToken.getSecond())){
                return true;
            }
        }

        return false;
    }
}
