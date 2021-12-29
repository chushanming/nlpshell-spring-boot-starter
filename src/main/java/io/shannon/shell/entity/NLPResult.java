package io.shannon.shell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NLPResult implements Serializable {

    private static final long serialVersionUID = 7617137292286238283L;

    ArrayList<String> ListOfNN;
    ArrayList<String> ListOfNER;
}
