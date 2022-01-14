package test;

import methods.DragDropMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DragDropTest extends DragDropMethod {

    @Test
    public void dragDropTest() {
        startDragDropTest();
        assertNotEquals(originalA, afterA);
        assertNotEquals(originalB, afterB);
    }
}
