package assessment;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicWaitPage;
import util.Driver;

public class DynamicWait extends Driver {

    DynamicWaitPage page = new DynamicWaitPage(Driver.getDriver());

    @Test
    public void dynamic_wait_test() {
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

        page.startButton.click();

        Driver.getWait().until(ExpectedConditions.invisibilityOf(page.loadingBar));

        String expectedText = "Hello World!";

        Assert.assertEquals(page.message.getText() , expectedText , "message after loading finish incorrect -> actual message: " + page.message.getText());
    }
}
