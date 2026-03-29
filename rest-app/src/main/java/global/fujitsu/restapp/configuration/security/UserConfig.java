package global.fujitsu.restapp.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/** Sets up default users and creates bean for password encoder. */
@Configuration
@EnableWebSecurity
public class UserConfig {

  @Value("${env.ADMIN_USERNAME}")
  private String adminName;
  @Value("${env.ADMIN_PASSWORD}")
  private String adminPassword;
  @Value("${env.USER_USERNAME}")
  private String userName;
  @Value("${env.USER_PASSWORD}")
  private String userPassword;

  /** Sets up default users. */
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails admin = User.withUsername(adminName)
        .password(passwordEncoder().encode(adminPassword))
        .roles("ADMIN")
        .build();

    UserDetails user = User.withUsername(userName)
        .password(passwordEncoder().encode(userPassword))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user);
  }

  /** Beans password encoder. */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

}
