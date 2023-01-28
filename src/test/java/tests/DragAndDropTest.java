package tests;

import org.junit.jupiter.api.*;
import pages.DragAndDropPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DragAndDropTest extends BaseTest {
    private static final String DRAG_N_DROP_URI = "/drag_and_drop";
    private static final String PAGE_TITLE = "Drag and Drop";

    private static DragAndDropPage dragAndDropPage;

    @BeforeAll
    static void before() {
        dragAndDropPage = new DragAndDropPage(webDriver);
        webDriver.get(baseUrl + DRAG_N_DROP_URI);
    }

    @Test
    @Order(1)
    void validateDragAndDropPage() {
        dragAndDropPage.assertElementsAreDisplayed();
        dragAndDropPage.assertPageTitle(PAGE_TITLE);
    }

    @Test
    @Order(2)
    void testElementsDrag() {
        dragAndDrop(dragAndDropPage.getColumnA(), dragAndDropPage.getColumnB());
        dragAndDropPage.assertColumnsDrag();
    }

}
