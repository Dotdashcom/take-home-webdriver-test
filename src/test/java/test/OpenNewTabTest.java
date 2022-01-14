package test;

import methods.OpenNewTabMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class OpenNewTabTest extends OpenNewTabMethod {
    private final String text = "New Window";

    @Test
    public void openNewTabTest() {
        startOpenNewTabTest();
        assertEquals(getContent(), text);
    }
}
