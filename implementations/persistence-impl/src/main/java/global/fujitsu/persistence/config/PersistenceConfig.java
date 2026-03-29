package global.fujitsu.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Enables unique name for spring .properties. This was added to prevent conflicts when project is
 * being implemented into another.
 */
@Configuration
@PropertySource("classpath:persistence.properties")
@PropertySource(value = "classpath:persistence-${spring.profiles.active}.properties",
    ignoreResourceNotFound = true)
public class PersistenceConfig {

}
