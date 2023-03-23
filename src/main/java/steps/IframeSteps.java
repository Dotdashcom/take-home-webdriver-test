package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.IframePage;

public class IframeSteps {

    IframePage iframePage = new IframePage();

    @Step("Type text in iframe")
    public void typeTextInIframe(String text){
        iframePage.switchToIframe();
        iframePage.sendText(text);
    }

    @Step("Check text in iframe")
    public void checkText(String text){
        Assert.assertEquals(iframePage.getText(), text);
    }

}
