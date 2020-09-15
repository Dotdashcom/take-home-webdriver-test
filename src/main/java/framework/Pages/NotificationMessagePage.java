package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import sun.tools.tree.ShiftRightExpression;

import java.util.ArrayList;
import java.util.List;

public class NotificationMessagePage {
    WebDriver driver;

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text() = 'Click here']")
    WebElement clickHereButton;

    @FindBy(id = "flash")
    WebElement notificationMessage;

    public void generateNotifcationMessage(){
        clickHereButton.click();;

        String notifcationText = notificationMessage.getText();
        String actionSuccessful = "Action Successful";
        String actionUnsuccesfulTryAgain = "Action unsuccesful, please try again";
        String actionUnsuccesful = "Action unsuccessful";

        if (notifcationText.equals(actionSuccessful)
                || notifcationText.equals(actionUnsuccesfulTryAgain)
                || notifcationText.equals(actionUnsuccesful)) {
            Assert.fail("Message did not match: " + actionSuccessful + actionUnsuccesful + actionUnsuccesfulTryAgain);
        }

    }
}
