import java.util.ArrayList;
import java.util.Collections;

public class Comparator implements java.util.Comparator<Human> {

    public int compare(Human human1, Human human2) {
        int nameCompare = human1.getPatronymic().compareTo(human2.getPatronymic());
        if (nameCompare == 0) {
            nameCompare = human1.getFirstName().compareTo(human2.getFirstName());
            if(nameCompare == 0) {
                return human1.getLastName().compareTo(human2.getLastName());
            }
        }
        return nameCompare;
    }
}
