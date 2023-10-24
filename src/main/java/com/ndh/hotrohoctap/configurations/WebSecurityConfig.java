package com.ndh.hotrohoctap.configurations;


import com.ndh.hotrohoctap.filters.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;
    private final UserDetailsService userDetailsService;
    @Value("${api.prefix}")
    private String apiPrefix;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                    .csrf(AbstractHttpConfigurer::disable)
                    .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeHttpRequests(request -> {
                        request
                                .requestMatchers(
                                        String.format("%s/users/register", apiPrefix),
                                        String.format("%s/users/login", apiPrefix),
                                        String.format("%s/baiTap", apiPrefix),
                                        String.format("%s/baiTap/**", apiPrefix),
                                        String.format("%s/diemBaiTap", apiPrefix),
                                        String.format("%s/monhoc", apiPrefix),
                                        String.format("%s/diemMonHoc", apiPrefix),
                                        String.format("%s/diemMonHoc/**", apiPrefix),
                                        String.format("%s/diemMonHoc/lessThan5", apiPrefix),
                                        String.format("%s/diemMonHoc/greaterThan8", apiPrefix),
                                        String.format("%s/thongbao", apiPrefix)
                                )
                                .permitAll()

                                .requestMatchers(POST,
                                        String.format("%s/users/register", apiPrefix)).permitAll()
                                .requestMatchers(POST,
                                        String.format("%s/diemBaiTap", apiPrefix)).permitAll()
                                .requestMatchers(GET,
                                        String.format("%s/pdf", apiPrefix)).permitAll()
                                .requestMatchers(GET,
                                        String.format("%s/sendmail", apiPrefix)).permitAll()
                                .requestMatchers(GET,
                                        String.format("%s/pdf/nguoidung", apiPrefix)).permitAll()
                                .requestMatchers(GET,
                                        String.format("%s/pdf/diem", apiPrefix)).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/quanlydiem")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/nguoidung")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/quanlymonhoc")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/quanlybaitap")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/quanlybaitap/searchBaiTap**")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/quanlybaitap/searchBaiTap")).permitAll()
                                .requestMatchers(PUT,
                                        ("/admin/nguoidung/**")).permitAll()
                                .requestMatchers(GET,
                                        ("/trangchu")).permitAll()
                                .requestMatchers(PUT,
                                        ("/admin/nguoidung/disable-user/**")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/thongke")).permitAll()
                                .requestMatchers(GET,
                                        ("/admin/**")).permitAll()
                                .anyRequest().authenticated();

                    })   .csrf(AbstractHttpConfigurer::disable);

        http.cors(new Customizer<CorsConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CorsConfigurer<HttpSecurity> httpSecurityCorsConfigurer) {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(List.of("*"));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
                configuration.setExposedHeaders(List.of("x-auth-token"));
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                httpSecurityCorsConfigurer.configurationSource(source);
            }
        });
        return  http.build();
    }

}
