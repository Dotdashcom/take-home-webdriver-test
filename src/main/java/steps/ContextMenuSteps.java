package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ContextMenuPage;

public class ContextMenuSteps {

    ContextMenuPage contextMenuPage = new ContextMenuPage();

    public void rightClickToHotSpot(){
        contextMenuPage.rightClickHotSpot();
    }

    @Step("Check alert text")
    public void checkAlertText(String expectedText){
        Assert.assertEquals(contextMenuPage.getAlertText(), expectedText);
    }

}
