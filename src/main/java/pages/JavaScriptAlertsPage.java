package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertsPage extends BasicPage {
    WebDriver driver;
    Alert alert;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button")
    WebElement jsAlertBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button")
    WebElement jsConfirmBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button")
    WebElement jsPromptBtn;

    @FindBy(xpath = "//*[@id=\"result\"]")
    WebElement result;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/javascript_alerts");
        PageFactory.initElements(this.driver, this);
    }

    public void testJSAlert() {
        this.jsAlertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    public void testJSPrompt(String enterContent) {
        this.jsPromptBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.alert = wait.until(ExpectedConditions.alertIsPresent());
        this.alert.sendKeys(enterContent);
        this.alert.accept();
    }

    public void testJSConfirm() {
        this.jsConfirmBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.alert = wait.until(ExpectedConditions.alertIsPresent());
        this.alert.accept();
    }

    public void assertAlertContent(String expectedContent) {
        Assert.assertEquals(expectedContent, this.alert.getText());
        this.alert.dismiss();
    }

    public void assertAlertResultContent(String expectedContent) {
        Assert.assertEquals(expectedContent, this.result.getText());
    }

    public void assertResultContainContent(String containedContent) {
        Assert.assertTrue(this.result.getText().contains(containedContent));
    }
}
