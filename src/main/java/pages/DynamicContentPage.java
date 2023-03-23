package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DynamicContentPage {

    private SelenideElement content = $(".large-10");

    @Step("Get content")
    public String getContentText(){
        return this.content.getText();
    }
}
