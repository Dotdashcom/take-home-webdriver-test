package tests;

import enums.Headers;
import enums.Pages;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropTest extends TestBase {

    @Test(description = "Drag and drop test")
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        BrowserUtils.openPage(driver, Pages.DRAG_AND_DROP_PAGE);
        BrowserUtils.waitUntilVisible(driver, dragAndDropPage.header, Duration.ofSeconds(15));
        assertThat(dragAndDropPage.header.getText()).isEqualTo(Headers.DRAG_AND_DROP.getName());
        assertThat(dragAndDropPage.columnA.getText()).isEqualTo("A");
        assertThat(dragAndDropPage.columnB.getText()).isEqualTo("B");
        BrowserUtils.dragdropByJsExecutor(driver, dragAndDropPage.columnA, dragAndDropPage.columnB);
        assertThat(dragAndDropPage.columnA.getText()).isEqualTo("B");
        assertThat(dragAndDropPage.columnB.getText()).isEqualTo("A");
    }
}
