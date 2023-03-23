package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class JavaScriptAlertsPage {

    private SelenideElement buttonJsAlert = $(new ByAttribute("onclick", "jsAlert()"));
    private SelenideElement buttonJsConfirm = $(new ByAttribute("onclick", "jsConfirm()"));
    private SelenideElement buttonJsPrompt = $(new ByAttribute("onclick", "jsPrompt()"));
    private SelenideElement result = $("#result");

    @Step("Click for JS Alert")
    public void clickForJsAlert(){
        buttonJsAlert.click();
    }

    @Step("Click for JS Confirm")
    public void clickForJsConfirm(){
        buttonJsConfirm.click();
    }

    @Step("Click for JS Prompt")
    public void clickForJsPrompt(){
        buttonJsPrompt.click();
    }

    @Step("Get Text for JS Alert")
    public String getTextForJsAlert(){
        return switchTo().alert().getText();
    }

    @Step("Send Text to JS Prompt")
    public void sendTextForJsPrompt(String text){
        switchTo().alert().sendKeys(text);
    }

    @Step("Close alert message")
    public void closeJsAlert(){
        switchTo().alert().dismiss();
    }

    @Step("Accept alert message")
    public void acceptJsAlert(){
        switchTo().alert().accept();
    }

    @Step("Get text result")
    public String getTextResult(){
        return result.getText();
    }

}
