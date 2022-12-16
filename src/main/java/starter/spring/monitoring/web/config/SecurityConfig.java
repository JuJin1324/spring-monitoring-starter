package starter.spring.monitoring.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import starter.spring.monitoring.web.provider.MonitoringAuthenticationProvider;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2022/10/24
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final MonitoringAuthenticationProvider monitoringAuthenticationProvider;

    @Bean
    public SecurityFilterChain monitoringFilterChain(HttpSecurity http) throws Exception {
        http
                .antMatcher("/actuator/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/actuator/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .realmName("Application Monitoring")
                .and()
                .authenticationProvider(monitoringAuthenticationProvider);

        return http.build();
    }
}
