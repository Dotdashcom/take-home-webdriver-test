package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    public WebDriver driver;

    public NotificationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='flash']")
    private WebElement clickHere;

    @FindBy(id = "flash")
    private WebElement alert;

    public boolean validateAlertText(String text) throws InterruptedException {
        Helpers.WaitForElement(alert);
        System.out.println(Helpers.GetDoubleQuotedText(alert));
        return alert.getText().contains(text);
    }


    public void clickNewNotification() {
        Helpers.ClickElement(clickHere);
    }


    public void makeAppertext(String text) throws InterruptedException {
       // Helpers.WaitForElement(alert);
       clickNewNotification();

       for (int i =0;i<30;i++)
       {
        if (Helpers.GetDoubleQuotedText(alert).trim().toLowerCase().contains(text.trim().toLowerCase())){
              break;
            }
        else {
            Helpers.Refresh();
            Thread.sleep(1000);
             clickNewNotification();

            }

        }
    }
}
