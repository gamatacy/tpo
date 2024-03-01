package org.example;


public class Arthur extends Human implements Moveable {

    public Arthur(String name, Place currentPlace) {
        super(name, currentPlace);
    }

    @Override
    public void walkTo(Place place) {
        this.setCurrentPlace(place);
    }

    @Override
    public void slideTo(Place place) {
        this.setCurrentPlace(place);
    }

}
