import org.benjamin.pages.DropDown;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DropDownTest extends DropDown {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void dropDown_select1_selected(){
        selectDropDown("1");
        Assertions.assertEquals("1", getSelected());
    }

    @Test
    public void dropDown_select2_selected(){
        selectDropDown("2");
        Assertions.assertEquals("2", getSelected());
    }
}
