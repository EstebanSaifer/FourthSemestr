import java.util.ArrayList;
import java.util.List;

public class CollectionsDemo {

    public static int countOfStrInArrayList(List<String> list0, char x) {
        int count = 0;
        for (String str : list0) {
            if (str != null && str.charAt(0) == x) {
                count++;
            }
        }
        return count;
    }
}
