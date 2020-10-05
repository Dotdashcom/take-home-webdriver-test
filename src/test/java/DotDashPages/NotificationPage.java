package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage {

    public WebDriver ldriver;

    public NotificationPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the click here link
    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    WebElement lnkClickhere;

    //Capture the notification message
    @FindBy(xpath = "//div[@id='flash']")
    WebElement txtnotification;


    //Click on Click here link
    public void clklnkClickhere()
    {
        lnkClickhere.click();
    }

    //Get the text from the notification
    public String gettxtnotification()
    {
        WebDriverWait wait = new WebDriverWait(ldriver, 40);
        wait.until(ExpectedConditions.visibilityOf(txtnotification));
        return txtnotification.getText();
    }


}
