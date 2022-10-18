package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class NotificationMessagesPage extends BasePage {

    public NotificationMessagesPage(WebDriver driver){

        super(driver);
        driver.get(prop.getProperty("baseurl") + "/notification_message_rendered");
    }


    @FindBy(xpath = "//a[text()='Click here']")
    private WebElement clickHereBtn;


    public void clickClickHereBtn(){
        clickHereBtn.click();
    }

    public void clickUntilOneOfTheMessagesBeDisplayed10Times(){

        int messageSuccessfull = 0;
        int messageUnsuccessfull = 0;

        do {
            clickClickHereBtn();

            WebElement message = driver.findElement(By.id("flash"));

            if (message.getText().equals("Action successful\n" + "×")){
                messageSuccessfull++;
            }
            else {
                messageUnsuccessfull++;
            }

        }
        while ((messageSuccessfull < 10 && messageUnsuccessfull < messageSuccessfull) || (messageUnsuccessfull < 10 && messageSuccessfull < messageUnsuccessfull));

    }


}
