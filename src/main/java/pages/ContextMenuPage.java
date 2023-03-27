package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    protected WebElement contextMenu;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public String rightClickAndText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contextMenu).contextClick(contextMenu).build().perform();
        String textFromAlert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return textFromAlert;
    }
}
