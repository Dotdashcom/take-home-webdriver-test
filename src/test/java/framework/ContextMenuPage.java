package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage{

    @FindBy(xpath = "//div[@id='hot-spot']")
    WebElement box;

    public ContextMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void contextMenuActions(WebDriver driver) {
        rightClick(driver, box);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
