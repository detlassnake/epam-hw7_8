package ua.epam.hw7_8Test;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw7_8.repository.io.JavaIOUtilLogic;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class UtilLogicTest {
    ArrayList<String> arrayList;
    long result1 = 6L;
    long result2 = 3L;
    @Before
    public void setUp() {
        arrayList = new ArrayList<String>();
        arrayList.add("1 qwert");
        arrayList.add("6 qwerty");
        arrayList.add("3 qwertyu");
    }
    @Test
    public void maxIdTest() {
        setUp();
        long input = JavaIOUtilLogic.maxId(arrayList);
        assertEquals(result1, input);
    }
    @Test
    public void lastIdTest() {
        setUp();
        long input = JavaIOUtilLogic.lastId(arrayList);
        assertEquals(result2, input);
    }
}