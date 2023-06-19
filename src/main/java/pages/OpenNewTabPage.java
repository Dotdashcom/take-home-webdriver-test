package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class OpenNewTabPage {

    private WebDriver driver;

    public OpenNewTabPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Click Here']")
    private WebElement clickHereLinkField;

    @FindBy(xpath = "//h3[text()='New Window']")
    private WebElement newTabMessage;

    public String switchToTabs() {
        clickHereLinkField.click();
        Set<String> windows = driver.getWindowHandles();
        for(String windowName:windows){
            driver.switchTo().window(windowName);
        }
        return newTabMessage.getText();
    }
}
