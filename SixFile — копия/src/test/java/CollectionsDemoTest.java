import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CollectionsDemoTest {

    @Test
    public void test0() {
        CollectionsDemo collectionsDemo = new CollectionsDemo();
        ArrayList<String> list = new ArrayList<String>();
        list.add("qqqqqq");
        list.add("oqoqoq");
        list.add("qoqoqo");
        assertEquals(2, CollectionsDemo.countOfStrInArrayList(list, 'q'));
    }
}