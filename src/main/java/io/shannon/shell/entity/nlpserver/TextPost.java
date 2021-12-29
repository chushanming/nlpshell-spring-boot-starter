package io.shannon.shell.entity.nlpserver;

import lombok.Data;

@Data
public class TextPost {

    //key
    private Long id;
    //target contains vulnerability
    private String target;
    //vulnerability
    private String vulnerability;
    //input
    private String input;
}
