package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FloatingMenuPage {

    private SelenideElement menu = $("#menu");
    private SelenideElement link = $(By.linkText("Elemental Selenium"));

    @Step("Scroll page to bottom")
    public void scrollPage(){
        this.link.scrollTo();
    }

    @Step("Menu is displayed")
    public void isMenuDisplayed(){
        this.menu.isDisplayed();
    }


}
