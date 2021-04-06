package TakeHome.pages;

import TakeHome.utilities.BrowserUtils;
import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage extends BasePage {
    public WindowsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@href='/windows/new']")
    private WebElement windowButton;

    public void switchToNewWindow(){
        windowButton.click();
        BrowserUtils.switchToWindow("New Window");
    }
}
