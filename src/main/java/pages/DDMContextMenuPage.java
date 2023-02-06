package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DDMContextMenuPage extends DDMBasePage  {

    @FindBy(id = "hot-spot")
    protected WebElement contextMenu;

    public DDMContextMenuPage(WebDriver driver)  {
        super(driver);
    }

    public void rightClick()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(contextMenu).contextClick(contextMenu).build().perform();
    }

    public String getAlertText()  {
        String textFromAlert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return textFromAlert;
    }
}