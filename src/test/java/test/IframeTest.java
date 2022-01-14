package test;

import methods.IframeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class IframeTest extends IframeMethod {
    private final String text = "Hello World!";

    @Test
    public void iframeTest() {
        startIframeTest(text);
        assertEquals(getContent(), text);
    }
}
