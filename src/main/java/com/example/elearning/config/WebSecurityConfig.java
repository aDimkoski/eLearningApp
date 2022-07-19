package com.example.elearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserPasswordAuthenticationProvider customUserPasswordAuthenticationProvider;

    public WebSecurityConfig(PasswordEncoder passwordEncoder,
                             CustomUserPasswordAuthenticationProvider customUserPasswordAuthenticationProvider) {
        this.passwordEncoder = passwordEncoder;
        this.customUserPasswordAuthenticationProvider = customUserPasswordAuthenticationProvider;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**","/img/**","/pdf/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/assets/**", "/register", "/api/**","/about","/ourteam","/contact","/courses").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
        //http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().and().headers().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customUserPasswordAuthenticationProvider);
    }
}
