import org.benjamin.pages.DynamicLoading;
import org.junit.jupiter.api.*;

public class DynamicLoadingTest extends DynamicLoading {
    @Test
    @Order(1)
    public void checkbox_remove_gone(){
        String text = clickStart();
        Assertions.assertEquals("Hello World!", text);
    }
}
