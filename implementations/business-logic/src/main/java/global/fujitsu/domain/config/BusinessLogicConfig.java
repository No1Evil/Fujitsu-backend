package global.fujitsu.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:business-logic.properties")
@ComponentScan(basePackages = "global.fujitsu.domain")
public class BusinessLogicConfig {

}
