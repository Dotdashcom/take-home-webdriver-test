import org.benjamin.pages.MouseHover;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MouseHoverTest extends MouseHover {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void mouseHover_hover1_displayCorresponding(){
        hover(1);
        Assertions.assertTrue(isMessageDisplayed(1));
    }

    @Test
    public void mouseHover_hover2_displayCorresponding(){
        hover(2);
        Assertions.assertTrue(isMessageDisplayed(2));
    }

    @Test
    public void mouseHover_hover3_displayCorresponding(){
        hover(3);
        Assertions.assertTrue(isMessageDisplayed(3));
    }
}
