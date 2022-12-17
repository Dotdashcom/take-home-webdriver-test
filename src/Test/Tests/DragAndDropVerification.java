package Tests;

import Pages.BasePage;
import Pages.DragAndDropPage;
import Utils.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropVerification extends BasePage {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/drag_and_drop");
    }

    @Test
    public void TC1DragAndDropVerification(){
        dragAndDropPage.DragAndDrop();

    }

}
