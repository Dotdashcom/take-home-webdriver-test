import org.benjamin.pages.FloatingMenu;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FloatingMenuTest extends FloatingMenu {

    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void floatingMenu_scroll_menuDisplayed(){
        scroll();
        Assertions.assertTrue(isFloatingMenuDisplayed());
    }
}
