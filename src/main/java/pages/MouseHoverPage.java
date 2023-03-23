package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MouseHoverPage {


    @Step("Mouse hover on User {user}")
    public void mouseHoverOnUser(int user)
    {
        $(By.xpath("//*[@id=\"content\"]/div/div["+user+"]/img")).hover();
    }

    @Step("Text should be visible on website")
    public void userInfoShouldBeVisible(int user){
        $(byText("name: user"+user+"")).shouldBe(visible);
    }
}
