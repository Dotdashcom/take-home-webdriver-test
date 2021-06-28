package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class MultipleWindowsPage extends PageBase {
    @FindBy(xpath = "")
    protected WebElement newTubLink;

    @FindBy(xpath = "//h3")
    WebElement newWindow;

    public void checkNewWindow(){
        newTubLink.click();
        BrowserUtils.switchToWindow(newWindow.getText(),"Opening a new window");
    }
}
