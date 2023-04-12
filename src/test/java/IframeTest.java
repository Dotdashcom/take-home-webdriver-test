import org.benjamin.pages.Iframe;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IframeTest extends Iframe {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void iframe_type_same() {
        String text = "test";
        typeInIframe(text);

        String inputText = getInputText();
        Assertions.assertEquals(text + "Your content goes here.", inputText);
    }
}
