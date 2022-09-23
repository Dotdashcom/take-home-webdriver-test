package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends AbstractWebPage {

    @FindBy(id = "hot-spot")
    protected WebElement specialBoxElm;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickOnBox() {
        mkbActions.moveToElement(specialBoxElm).contextClick().build().perform();
    }

    public String getTextFromAlert() {
        String textFromAlert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        //Hack to get rid off context menu options on the browser
        pressEscRobot();

        return textFromAlert;
    }
}