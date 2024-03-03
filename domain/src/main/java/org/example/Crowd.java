package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Crowd {

    private List<Human> humans;

    public Crowd(List<Human> humans){
        this.humans = humans;
    }

}
