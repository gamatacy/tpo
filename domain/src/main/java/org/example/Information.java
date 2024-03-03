package org.example;

import lombok.Getter;
import lombok.Setter;

public class Information {
    private String thing;
    private InformationTag tag;

    public Information(String thing, InformationTag tag) {
        this.thing = thing;
        this.tag = tag;
    }

}
