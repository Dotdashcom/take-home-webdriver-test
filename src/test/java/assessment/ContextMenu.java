package assessment;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import util.Driver;

public class ContextMenu extends Driver {

    ContextMenuPage page = new ContextMenuPage(Driver.getDriver());

    @Test
    public void right_click_alert_trigger_test() {
        Driver.getDriver().get("http://localhost:7080/context_menu");

        Driver.getActions().moveToElement(page.hotSpot).contextClick().build().perform();

        if (Driver.getWait().until(ExpectedConditions.alertIsPresent()) != null) {
            String expectedText = "You selected a context menu";
            Assert.assertEquals(Driver.getDriver().switchTo().alert().getText() , expectedText , "alert message incorrect");
        } else {
            Assert.fail("alert is not present");
        }
    }
}
