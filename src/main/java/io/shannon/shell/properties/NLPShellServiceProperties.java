package io.shannon.shell.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("nlpshell.corenlp")
public class NLPShellServiceProperties {

    private String remoteHost;

    private String remotePort = "9000";

}
