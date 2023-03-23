package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DynamicControlsPage {

    private SelenideElement checkbox = $("#checkbox");
    private SelenideElement buttonRemoveAdd = $(By.xpath("//*[@id=\"checkbox-example\"]/button"));
    private SelenideElement inputEnableDisable = $(By.xpath("//*[@id=\"input-example\"]/input"));
    private SelenideElement buttonEnableDisable= $(By.xpath("//*[@id=\"input-example\"]/button"));

    @Step("Checkbox status should be checked")
    public void checkboxShouldBeVisible(){
        this.checkbox.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Checkbox status should not be checked")
    public void checkboxShouldNoBeVisible(){
        this.checkbox.shouldNotBe(visible, Duration.ofSeconds(10));
    }

    @Step("Press button RemoveAdd")
    public void pressButtonRemoveAdd() {
        this.buttonRemoveAdd.click();
    }

    @Step("Press button EnableDisable")
    public void pressButtonEnableDisable(){
        this.buttonEnableDisable.click();
    }

    @Step("Input field should be disabled")
    public void inputFieldShouldBeDisabled(){
        this.inputEnableDisable.shouldNotBe(disabled, Duration.ofSeconds(10));
    }

    @Step("Input field should be Enabled")
    public void inputFieldShouldBeEnabled(){
        this.inputEnableDisable.shouldNotBe(enabled, Duration.ofSeconds(10));
    }

}
