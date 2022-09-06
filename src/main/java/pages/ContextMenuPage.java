package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class ContextMenuPage extends TestBase {
    WebDriver driver = TestBase.getInstance().getDriver();
    @FindBy(xpath = "(//div[@id='hot-spot'])[1]")
    WebElement contextMenuBox;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement checkBox2;

    public ContextMenuPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuBox).perform();
    }

    public String handleAlert() {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }
}
