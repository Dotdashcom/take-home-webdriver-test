package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(id="hot-spot")
    WebElement contextArea;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClick(){
        Actions action = new Actions(driver);
        action.contextClick(contextArea).perform();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

}
