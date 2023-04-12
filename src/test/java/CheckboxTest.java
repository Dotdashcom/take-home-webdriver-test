import org.benjamin.pages.Checkbox;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckboxTest extends Checkbox {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    @Order(1)
    public void checkbox_clickBox1_checked(){
        String checked = click(1);

        Assertions.assertEquals("true", checked);
    }

    @Test
    @Order(2)
    public void checkbox_clickBox1_unchecked(){
        String checked = click(1);

        Assertions.assertNull(checked);
    }

    @Test
    @Order(3)
    public void checkbox_clickBox2_unchecked(){
        String checked = click(2);

        Assertions.assertNull(checked);
    }

    @Test
    @Order(4)
    public void checkbox_clickBox2_checked(){
        String checked = click(2);

        Assertions.assertEquals("true", checked);
    }
}
