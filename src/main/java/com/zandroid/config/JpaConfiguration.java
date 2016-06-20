package com.zandroid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {

        
        return () -> {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication == null ?"anonymousUser": authentication.getName();
        };
    }
}
