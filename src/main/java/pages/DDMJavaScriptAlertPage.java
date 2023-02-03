package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class DDMJavaScriptAlertPage extends DDMBasePage  {

    @FindBy(css = "div.example ul > li > :nth-child(1)")
    protected List<WebElement> allAlertOptions;

    @FindBy(css = "p[id = result]")
    protected WebElement alertMessage;

    public DDMJavaScriptAlertPage(WebDriver driver)  {
        super(driver);
    }

    public void clickOnAlert()  {
        allAlertOptions.get(0).click();
        driver.switchTo().alert().accept();
    }
    public String getClickOnAlertSuccessMessage()  {
        return alertMessage.getText();
    }
    public void clickJSconfirm()  {
        allAlertOptions.get(1).click();
        driver.switchTo().alert().accept();
    }
    public void clickJSprompt()  {
        allAlertOptions.get(2).click();
        driver.switchTo().alert().sendKeys("Hello there.");
        driver.switchTo().alert().accept();
    }
}