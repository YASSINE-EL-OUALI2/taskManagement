package com.example.teamfive.taskmanagement.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.teamfive.taskmanagement.Security.jwt.AuthEntryPointJwt;
import com.example.teamfive.taskmanagement.Security.jwt.AuthTokenFilter;
import com.example.teamfive.taskmanagement.Service.Authentication.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticatonJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/api/auth/**", "/v3/api-docs/**", "/swagger-ui/**", "/api/roles/**","/api/users/**").permitAll()
                                    .requestMatchers("/api/test/**").hasAnyRole("ADMIN", "USER")
                                    
                                    .requestMatchers("/api/comment/getAll").hasAnyRole("ADMIN", "USER")
                                    .requestMatchers("/api/comment/add").hasRole("ADMIN")
                                    .requestMatchers("/api/comment/update").hasRole("ADMIN")
                                    .requestMatchers("/api/comment/delete").hasRole("ADMIN")
                                    .requestMatchers("/api/comment/getUserById").hasAnyRole("ADMIN", "USER")

                                    .requestMatchers("/api/task/getAll").hasAnyRole("ADMIN", "USER")
                                    .requestMatchers("/api/task/add").hasRole("ADMIN")
                                    .requestMatchers("/api/task/update").hasRole("ADMIN")
                                    .requestMatchers("/api/task/delete").hasRole("ADMIN")
                                    .requestMatchers("/api/task/getUserById").hasAnyRole("ADMIN", "USER")

                                    .anyRequest().authenticated()
                                );

        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticatonJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
