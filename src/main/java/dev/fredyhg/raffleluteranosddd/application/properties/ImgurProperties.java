package dev.fredyhg.raffleluteranosddd.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app.imgur")
@Getter
@Setter
@Component
public class ImgurProperties {
    private String clientId;
}
