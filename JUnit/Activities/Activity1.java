package Activities;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class Activity1 {
    static ArrayList<String> list;

    @BeforeAll
    public void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }
    @Test
    public void insertTest() {
        assertEquals(2, list.size(), "WrongSize");
        list.add("charlie");
        assertEquals(3,list.size(),"Wrong Size");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("charlie", list.get(2), "Wrong element");
    }

    @Test
    public void replaceTest() {
        list.set(1, "charlie");
        assertEquals(2, list.size(), "Wrong size");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("charlie", list.get(1), "Wrong element");
    }
}
