package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IframePage {

    private SelenideElement iframe = $("#mce_0_ifr");
    private SelenideElement textArea = $("#tinymce");

    @Step("Switch to iframe")
    public void switchToIframe(){
        switchTo().frame(this.iframe);
    }

    @Step("Send text to iframe")
    public void sendText(String text){
        this.textArea.clear();
        this.textArea.sendKeys(text);
    }

    @Step("Get text from iframe")
    public String getText(){
        return this.textArea.getText();
    }

}
