package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import takehome.utilities.Driver;

public class NewTabPage {
    public NewTabPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Multiple Windows")
    private WebElement multipleWindowsLink;
    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    public void clickOnMultipleWindowsLink(){
        multipleWindowsLink.click();
    }

    public String getWindowHandleId(){

        return Driver.getDriver().getWindowHandle();

    }
    public void clickOnNewTabLink   (){
        clickHereLink.click();
    }


}
