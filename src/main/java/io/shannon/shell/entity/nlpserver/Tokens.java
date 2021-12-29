package io.shannon.shell.entity.nlpserver;

import lombok.Data;

@Data
public class Tokens {

    private int index;
    private String word;
    private String originalText;
    private String lemma;
    private int characterOffsetBegin;
    private int characterOffsetEnd;
    private String pos;
    private String ner;
}
