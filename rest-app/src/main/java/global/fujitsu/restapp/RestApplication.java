package global.fujitsu.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "global.fujitsu")
public class RestApplication {
  static void main(String[] args){
    SpringApplication.run(RestApplication.class, args);
  }
}
