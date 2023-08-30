package proj.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.builder()
                .username("Ivan")
                .password(passwordEncoder.encode("password"))
                .roles("READ", "WRITE")
                .build();
        UserDetails user2 = User.builder()
                .username("Vasiliy")
                .password(passwordEncoder.encode("password2"))
                .roles("READ")
                .build();
        UserDetails user3 = User.builder()
                .username("Tamara")
                .password(passwordEncoder.encode("password3"))
                .roles("DELETE")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
