package com.fmi.MovieRating.security.config;

import com.fmi.MovieRating.exceptions.handler.AuthenticationEntryPointJwt;
import com.fmi.MovieRating.security.AccountDetailsService;
import com.fmi.MovieRating.security.jwt.JwtUtils;
import com.fmi.MovieRating.security.jwt.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPointJwt unauthorizedHandler;

    @Bean
    public AccountDetailsService userDetailsService() { return new AccountDetailsService(); }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(10); }

    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtUtils jwtUtils() { return new JwtUtils(); }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() { return new TokenAuthenticationFilter(); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPointJwt()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/v*/authentication/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v*/movies/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v*/reviews/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v*/accounts/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v*/individuals/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v*/reviews/").authenticated();

        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
