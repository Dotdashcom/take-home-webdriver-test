package e2e.tests;

import e2e.pages.DragAndDropPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends BaseSpec {
    DragAndDropPage dragAndDropPage;
    public final String dragAndDropEndpoint = configReader.getDragAndDropEndpoint();

    @BeforeEach
    public void open(){
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.visit(dragAndDropEndpoint);
    }

    @Test
    public void validateDragAndDropColumnsSwitched() {
        Assertions.assertEquals("A", dragAndDropPage.getColumnAText());
        Assertions.assertEquals("B", dragAndDropPage.getColumnBText());

        dragAndDropPage.dragAndDrop();

        Assertions.assertEquals("B", dragAndDropPage.getColumnAText());
        Assertions.assertEquals("A", dragAndDropPage.getColumnBText());
    }
}
