package io.shannon.shell.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("starter.service")
public class StarterServiceProperties {

    private String config;

    private String address;

}
