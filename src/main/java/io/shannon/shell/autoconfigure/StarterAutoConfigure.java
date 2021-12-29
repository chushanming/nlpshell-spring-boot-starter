package io.shannon.shell.autoconfigure;

import io.shannon.shell.properties.StarterServiceProperties;
import io.shannon.shell.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties starterServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    //@ConditionalOnProperty(prefix = "nlpshell.service", value = "enabled", havingValue = "true")
    StarterService starterService() {
        return new StarterService(starterServiceProperties.getConfig());
    }
}
