package org.example;

public interface Talkable {

    void talkTo(Human human, Information information);
    void talkTo(Crowd crowd, Information information);

    void talkTo(Information information);

}
