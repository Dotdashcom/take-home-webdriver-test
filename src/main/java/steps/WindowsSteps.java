package steps;

import io.qameta.allure.Step;
import pages.WindowsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class WindowsSteps {

    WindowsPage windowsPage = new WindowsPage();

    @Step("Check text in new tab")
    public void checkOpenedNewTabWithText (String textOnPage){
        windowsPage.clickLinkClickHere();
        switchTo().window(1);
        $("h3").shouldHave(text(textOnPage));
    }

}
