package test;

import methods.DynamicContentMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

// test to check if the refresh successful, and the contents should be different before and after refresh.
public class DynamicContentTest extends DynamicContentMethod {

    @Test
    public void dynamicContentTest() {
        int numOfRefresh = 3;
        startDynamicContentTest(numOfRefresh);
        assertFalse(isContentEqual(), "same contents" );

    }
}
