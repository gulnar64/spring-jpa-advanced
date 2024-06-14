package aze.coders.springjpaadvanced.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties
public class ApplicationConfig {
    //    private List<Branch> branches;
    private Map<String, String> branches;

    @PostConstruct
    public void init() {
        System.out.println("1: " + branches);
    }

}
