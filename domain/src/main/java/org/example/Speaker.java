package org.example;

public class Speaker extends Human implements Talkable {

    public Speaker(String name, Place currentPlace) {
        super(name, currentPlace);
    }

    @Override
    public void talkTo(Human human) {
        human.addInformationToBrain(new Information("pp talking", InformationTag.USELESS));
    }

    @Override
    public void talkTo(Crowd crowd) {
        for (Human human : crowd.getHumans()) {
            human.addInformationToBrain(new Information("pp talking", InformationTag.USELESS));
        }
    }

    @Override
    public void talkTo() {
        this.addInformationToBrain(new Information("pp talking", InformationTag.USELESS));
    }

}
