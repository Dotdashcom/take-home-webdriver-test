package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends BasePage{

    private By contextMenuBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        super(driver);
    }

    public void rightClickOnContextMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(contextMenuBox));
        WebElement element=getElement(contextMenuBox);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
