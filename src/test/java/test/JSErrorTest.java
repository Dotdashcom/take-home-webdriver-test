package test;

import methods.JSErrorMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class JSErrorTest extends JSErrorMethod {
    private final String errorMessage = "Cannot read properties of undefined (reading 'xyz')";

    @Test
    public void jsErrorTest() {
        startJSErrorTest();
        assertTrue(isError(errorMessage));
    }
}
