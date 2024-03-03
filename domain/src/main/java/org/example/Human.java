package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Human implements Moveable, Talkable {

    private String name;
    private Place currentPlace;
    private List<Information> brain;

    public Human(String name, Place currentPlace) {
        this.name = name;
        this.currentPlace = currentPlace;
        this.brain = new ArrayList<>();
    }

    private void addInformationToBrain(Information information) {
        this.brain.add(information);
    }

    @Override
    public void walkTo(Place place) {
        this.currentPlace = place;
    }

    @Override
    public void slideTo(Place place) {
        this.currentPlace = place;
    }

    @Override
    public void talkTo(Human human, Information information) {
        human.addInformationToBrain(information);
    }

    @Override
    public void talkTo(Crowd crowd, Information information) {
        for (Human human : crowd.getHumans()) {
            human.addInformationToBrain(information);
        }
    }

    @Override
    public void talkTo(Information information) {
        this.addInformationToBrain(information);
    }
}
