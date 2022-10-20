package src.test;

import org.testng.annotations.Test;
import src.main.pages.CheckBoxesPage;
import src.main.pages.MouseHoverPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class MouseTest extends BaseTest {



    private MouseHoverPage mouseHoverPage;

    @Test
    public void hoversTest() {
        mouseHoverPage = Browser.open(baseURL + "hovers", MouseHoverPage.class);

        for(int i = 0; i < 3; ++i) {
            mouseHoverPage.hoverOnUser(i);
            assertEquals(mouseHoverPage.getUserName(i), "name: user"+(i+1));
            assertEquals(mouseHoverPage.getProfileLink(i), "http://20.104.21.109:7080/users/"+(i+1));
        }
    }

}
