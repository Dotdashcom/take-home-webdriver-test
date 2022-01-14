package test;

import methods.DynamicLoadingMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DynamicLoadingTest extends DynamicLoadingMethod {
    @Test
    public void dynamicLoadingTest() {
        startDynamicLoadingTest();
        assertTrue(getAssertText().equals("Hello World!"));
    }
}
