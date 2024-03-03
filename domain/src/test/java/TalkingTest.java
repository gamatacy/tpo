import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TalkingTest {

    // todo: add check if brain even exists
    @Test
    public void testTalkToHuman() {
        Place place1 = new Place("3 этаж");
        Place place2 = new Place("Пляж Черногории");
        Human human1 = new Human("ПВ", place1);
        Human human2 = new Human("ПП", place2);

        Information information1 = new Information(
                "50% на допсе брат",
                InformationTag.USEFUL
        );

        human1.talkTo(human2, information1);

        assert human2.getBrain().get(0).equals(information1);

        Information information2 = new Information(
                "Мне пофиг, я так чувствую",
                InformationTag.USELESS
        );

        human2.talkTo(human1, information2);

        assert human1.getBrain().get(0).equals(information2);

        human1.getName();
    }

    @Test
    public void testTalkToCrowd() {
        Place place = new Place("Место");
        Human human1 = new Human("Человек 1", place);
        Human human2 = new Human("Человек 2", place);
        Human human3 = new Human("Человек 3", place);
        Human human4 = new Human("Человек 4", place);
        Human speaker = new Speaker("Спикер", place);

        List<Human> humans = new ArrayList<>();

        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);

        Crowd crowd = new Crowd(humans);
        Information information = new Information("Ребят, крипта пузырь", InformationTag.USEFUL);

        speaker.talkTo(crowd, information);

        crowd.getHumans().forEach(human -> {
            assert human.getBrain().get(0).equals(information);
        });
    }

    @Test
    public void talkToYourself() {
        Place place = new Place("Место");
        Human human = new Arthur("Человек", place);

        Information information = new Information("Щас курсики пройду и на 120к сразу выйду", InformationTag.USELESS);

        human.talkTo(information);

        assert human.getBrain().get(0).equals(information);

    }

}
