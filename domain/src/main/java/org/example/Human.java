package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Human {

    private String name;
    private Place currentPlace;
    private List<Information> brain;

    public Human(String name, Place currentPlace) {
        this.name = name;
        this.currentPlace = currentPlace;
        this.brain = new ArrayList<>();
    }

    public void addInformationToBrain(Information information) {
        this.brain.add(information);
    }

}
