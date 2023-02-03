package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DDMIframePage extends DDMBasePage  {
    @FindBy(xpath = "/html/body/p")
    protected WebElement iFrameText;
    public DDMIframePage(WebDriver driver)  {
        super(driver);
    }
    public void typeInsideIFrame()  {
        driver.switchTo().frame(0);
        waitInMilliSeconds(1000);

        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('body[class=\"mce-content-body \"]>p')[0].innerHTML=\"Hello there.\"");
    }
    public String  getIframeText()  {
        return iFrameText.getText();
    }
}
