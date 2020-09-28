package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class NotifiMsgPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public NotifiMsgPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy (linkText = "Notification Messages")
   public WebElement nMessageLink;
    @FindBy(linkText = "Click here")
    public WebElement clickHereLink;
    @FindBy(id = "flash")
    public WebElement actionMessage;

    public void clickOnNotifyMsgLink(){
        wait.until(ExpectedConditions.elementToBeClickable(nMessageLink));
        nMessageLink.click();
        clickHereLink.click();
    }
    public String getNoTxt(){
        return actionMessage.getText();
    }


}
