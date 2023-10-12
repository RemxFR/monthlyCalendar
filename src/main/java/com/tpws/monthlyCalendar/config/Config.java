package com.tpws.monthlyCalendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class Config implements WebMvcConfigurer {


    /*
    Méthode de configuration basique pour permettre la réception et l'acceptation de n'importe quelle requête http.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/**")
                .permitAll();

        return httpSecurity.build();
    }

    /*
    Méthode pour définir la validation des CORS et l'acceptation des requête http venant du port localhost:4200.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Authorization");
    }

}
