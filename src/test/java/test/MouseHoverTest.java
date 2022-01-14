package test;

import methods.MouseHoverMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MouseHoverTest extends MouseHoverMethod {
    @Test
    public void mouseHoverTest() {

        for(int i = 0; i < 3; i++) {
            startMouseHoverTest(i);
            assertTrue(isContentDisplayed(i));
        }
    }
}
