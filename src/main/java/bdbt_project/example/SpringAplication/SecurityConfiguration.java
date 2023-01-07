package bdbt_project.example.SpringAplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index", "/resources/static/**").permitAll()
                        .requestMatchers("/main").authenticated()
                        .requestMatchers("/main_user").hasRole("USER")
                        .requestMatchers("/main_admin", "/main/user").hasRole("ADMIN")
                        .anyRequest().authenticated() //Any other request that doesn’t match the rules above, will require authentication

                )
                .httpBasic()
                .and()
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/main")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/index?logout")
                        .permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user")
                        .roles("USER")
                        .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}