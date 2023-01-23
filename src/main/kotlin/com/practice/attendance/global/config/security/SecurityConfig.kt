package com.practice.attendance.global.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.practice.attendance.global.filter.config.FilterConfig
import com.practice.attendance.global.jwt.TokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val tokenProvider: TokenProvider,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeHttpRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            // Auth
            .requestMatchers("/auth/**").permitAll()

            // Admin
            .requestMatchers("/teacher/**").hasRole("TEACHER")

            //User
            .requestMatchers("/user/**").authenticated()

            .anyRequest().permitAll()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

            .and()
            .apply(FilterConfig(tokenProvider, objectMapper))

            .and()
            .build()
    }
}