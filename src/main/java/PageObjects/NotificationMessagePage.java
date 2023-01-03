package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage
{

    public NotificationMessagePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.CSS , using = "a[href='/notification_message']")
    WebElement clickHere;

    @FindBy( how = How.CSS , using = "#flash")
    WebElement flashMessage;

    public void clickOnClickHere()
    {
        clickHere.click();
    }

    public String getFashMessage() {
        return flashMessage.getText();
    }
}
