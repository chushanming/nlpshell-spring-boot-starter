package io.shannon.shell.entity.nlpserver;

import lombok.Data;

import java.util.List;

@Data
public class Response {

    private List<Sentences> sentences;
}
