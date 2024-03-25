package com.example.studentresultmanagementsystem.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable(); // Disable CSRF protection
//
//        http.authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                        .anyRequest().permitAll() // Permit access to any request
//        );
//
//        http.formLogin(formLogin ->
//                formLogin
//                        .loginPage("/login")
//                        .permitAll()
//        );
//
//        http.logout(logout ->
//                logout
//                        .permitAll()
//        );
//
//        return http.build();
//    }


    /* If we want to secure our urls without permitting the access we can do it as below as per the requirement
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .regexMatchers("/api/students/getStudents.*").permitAll()
                    .mvcMatchers("/api/students/addStudent").authenticated()
                    .antMatchers("/api/students/delete/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .permitAll()
            );
        return http.build();
    }
    */
}