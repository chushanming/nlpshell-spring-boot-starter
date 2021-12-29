package io.shannon.shell.entity.nlpserver;

import lombok.Data;

@Data
public class Entitymentions {

    private int docTokenBegin;
    private int docTokenEnd;
    private int tokenBegin;
    private int tokenEnd;
    private String text;
    private int characterOffsetBegin;
    private int characterOffsetEnd;
    private String ner;
    private NerConfidences nerConfidences;

}
