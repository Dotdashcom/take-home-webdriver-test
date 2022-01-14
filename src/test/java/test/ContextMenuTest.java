package test;

import methods.ContextMenuMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

// test for rightclicking on a context menu and triggering an alert text, if the expected text caught,
// this test should be passed.
public class ContextMenuTest extends ContextMenuMethod {

    @Test
    public void contextMenuTest() {
        startContextMenuTest();
        assertEquals(getAlertText(),"You selected a context menu");
    }
}
