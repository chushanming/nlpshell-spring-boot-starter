package io.shannon.shell.entity.nlpserver;

import lombok.Data;
import java.util.List;

@Data
public class Sentences {

    private int index;
    private List<Entitymentions> entitymentions;
    private List<Tokens> tokens;


}
