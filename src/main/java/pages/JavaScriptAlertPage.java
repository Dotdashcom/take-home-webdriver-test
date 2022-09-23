package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertPage extends BasePage {

    @FindBy(css = "div.example ul>li>:nth-child(1)")
    protected List<WebElement> alertElm;
    @FindBy(css = "p[id = result]")
    protected WebElement alertMessage;

    public JavaScriptAlertPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlert(){
        alertElm.get(0).click();
        driver.switchTo().alert().accept();
    }
    public String getClickOnAlertSuccessMessage(){
        return alertMessage.getText();
    }
    public void clickJSconfirm(){
        alertElm.get(1).click();
        driver.switchTo().alert().accept();
    }
    public void clickJSprompt(){
        alertElm.get(2).click();
        driver.switchTo().alert().sendKeys("Sending keys to alert prompt.");
        driver.switchTo().alert().accept();
    }
}
