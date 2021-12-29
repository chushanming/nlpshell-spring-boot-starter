package io.shannon.shell.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StarterService {

    private final String config;

    public boolean RemoteCallCoreNLP(String input) {
        System.out.println("Remote call CoreNLP form nlp-shell-spring-boot-starter "
                + input + " config: " + this.config);
        return true;
    }


}
