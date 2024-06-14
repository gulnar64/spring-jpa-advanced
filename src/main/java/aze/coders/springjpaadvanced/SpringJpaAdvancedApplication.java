package aze.coders.springjpaadvanced;

import aze.coders.springjpaadvanced.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@RequiredArgsConstructor
//@EnableConfigurationProperties(ApplicationConfig.class)
public class SpringJpaAdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaAdvancedApplication.class, args);
    }
}
