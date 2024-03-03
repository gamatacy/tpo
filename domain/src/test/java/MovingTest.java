import org.example.Building;
import org.example.Human;
import org.example.Place;
import org.junit.jupiter.api.Test;

public class MovingTest {

    @Test
    public void testMove(){
        Place subway = new Place("Горьковская");
        Place university = new Building("ИТМО");

        Human student = new Human("Саша П.", subway);

        student.walkTo(university);

        assert student.getCurrentPlace().equals(university);

        student.slideTo(subway);

        assert student.getCurrentPlace().equals(subway);
    }

}
