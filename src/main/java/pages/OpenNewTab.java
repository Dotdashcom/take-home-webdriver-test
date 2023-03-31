package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Utils.BrowserUtils;

public class OpenNewTab {
    public OpenNewTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[.='Click Here']")
    WebElement clickHereButton;
    @FindBy(xpath = "//h3[text()='New Window']")
    WebElement header;

    public String newWindow(WebDriver driver) {
        clickHereButton.click();
        String handle = driver.getWindowHandle();
        BrowserUtils.switchToNextTab(driver, handle);

        return header.getText();
    }
}
