package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class NewWindowsPage extends BasePage{
    public NewWindowsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Opening a new window')]")
    public WebElement newWindowsPageHeader;

    @FindBy(xpath = "//a[contains(.,'Click Here')]")
    public WebElement openNewWindowLink;

    @FindBy(xpath = " //h3[contains(.,'New Window')]")
    public WebElement newWindowText;

    public Boolean validatePageLanding(){
        newWindowsPageHeader.isDisplayed();
        return true;
    }


    public Boolean openNewWindow(){
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        openNewWindowLink.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        newWindowText.isDisplayed();
        return true;
    }
}
