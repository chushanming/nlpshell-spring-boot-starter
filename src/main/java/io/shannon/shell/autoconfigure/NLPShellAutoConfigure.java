package io.shannon.shell.autoconfigure;

import io.shannon.shell.properties.NLPShellServiceProperties;
import io.shannon.shell.service.NLPShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(NLPShellService.class)
@EnableConfigurationProperties(NLPShellServiceProperties.class)
public class NLPShellAutoConfigure {

    @Autowired
    private NLPShellServiceProperties nlpShellServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    NLPShellService nlpShellService() {
        return new NLPShellService(nlpShellServiceProperties.getRemoteHost(),
                nlpShellServiceProperties.getRemotePort());
    }
}
