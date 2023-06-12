package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    private WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement contextMenuBoxField;

    public void clickOnContextMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(contextMenuBoxField).contextClick().build().perform();
    }

    public String getAlertMenuText() {
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

}
