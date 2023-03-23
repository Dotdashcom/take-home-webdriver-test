package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.DynamicContentPage;

public class DynamicContentSteps {

    DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @Step("Check content after refreshes page")
    public void checkDynamicContent(){
        String a = dynamicContentPage.getContentText();
        Selenide.refresh();
        String b = dynamicContentPage.getContentText();
        Assert.assertNotEquals(a,b);
        Selenide.refresh();
        String c = dynamicContentPage.getContentText();
        Assert.assertNotEquals(b,c);
        Assert.assertNotEquals(a,c);
    }
}
