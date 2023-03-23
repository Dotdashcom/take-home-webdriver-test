package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxesPage {

    public SelenideElement checkbox1 = $(By.xpath("//form[@id='checkboxes']/input[1]"));
    public SelenideElement checkbox2 = $(By.xpath("//form[@id='checkboxes']/input[2]"));

    @Step("Checkbox status should be checked")
    public void checkboxShouldBeChecked(SelenideElement checkbox){
        checkbox.shouldBe(Condition.checked);
    }

    @Step("Checkbox status should not be checked")
    public void checkboxShouldNoBeChecked(SelenideElement checkbox){
        checkbox.shouldNotBe(Condition.checked);
    }

    @Step("Switch checkbox")
    public void switchCheckbox(SelenideElement checkbox){
        checkbox.click();
    }

}
