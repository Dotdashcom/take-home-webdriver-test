package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DynamicallyLoadedPage {


    private SelenideElement buttonStart = $(By.xpath("//*[@id=\"start\"]/button"));

    @Step("Press button Start")
    public void pressButtonStart() {
        this.buttonStart.click();
    }

    @Step("Text should be visible on website")
    public void textShouldBeVisible(String text){
        $(byText(text)).shouldBe(visible, Duration.ofSeconds(10));
    }

}
