package new_tab_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.new_tab_page.NewTabPage;
import page_object_model.new_tab_page.WindowPage;

import static org.testng.Assert.assertTrue;

public class NewTabTest extends Base {
    @Test
    public void newTabTest(){
        WindowPage windowPage = new WindowPage();
        windowPage.setClickHereLink();
        switchWindow();
        waitForVisibilityOfElement(NewTabPage.newWindowMessage);
        assertTrue(NewTabPage.newWindowMessage.isDisplayed());
    }
}
