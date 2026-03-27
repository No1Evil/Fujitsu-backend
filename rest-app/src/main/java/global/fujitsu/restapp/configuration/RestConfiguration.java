package global.fujitsu.restapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** WebMvc configuration. */
@Configuration
public class RestConfiguration implements WebMvcConfigurer {

  @Value("${ALLOWED_ORIGIN_PATTERN}")
  private String allowedOriginPattern;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(RestController.class));
  }

  /** Allows requests from env var {@code ${ALLOWED_ORIGIN_PATTERN}}. */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/**")
        .allowedOriginPatterns(allowedOriginPattern)
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true);
  }
}
