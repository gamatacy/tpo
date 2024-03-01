package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Place {

    private String name;

    public Place(String name) {
        this.name = name;
    }

}
