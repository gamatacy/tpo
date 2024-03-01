package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Crowd {

    private List<Human> humans;

    public Crowd(){
        this.humans = new ArrayList<>();
    }

    public Crowd(List<Human> humans){
        this.humans = humans;
    }

}
