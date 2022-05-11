import java.util.ArrayList;

public class CollectionsDemo {

    public static int countOfStrInArrayList( ArrayList<String> list0, char x) {
        int count = 0;
        for (String str : list0) {
            if (str != null && str.charAt(0) == x) {
                count++;
            }
        }
        return count;
    }
}
