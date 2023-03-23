package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class LoginPage {

    private SelenideElement inputUserName = $("#username");
    private SelenideElement inputPassword = $("#password");
    private SelenideElement buttonSubmit = $(new ByAttribute("type", "submit"));
    private SelenideElement message = $("#flash-messages");

    @Step("Enter user name: {userName}")
    public void enterUserName(String userName){
        this.inputUserName.sendKeys(userName);
    }

    @Step("Enter Password:*****")
    public void enterPassword(String userPassword){
        this.inputPassword.sendKeys(userPassword);
    }

    @Step("Press button Login on login form")
    public void clickOnLoginButton () {
        this.buttonSubmit.click();
    }

    @Step("Check display message: {message}")
    public void checkMassage(String message){
        this.message.shouldHave(text(message));
    }

}
