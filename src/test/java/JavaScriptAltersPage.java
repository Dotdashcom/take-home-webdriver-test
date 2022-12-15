import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaScriptAltersPage extends PageObject{
    @FindBy(xpath = "//button[@onclick=\"jsAlert()\"]")
    public WebElement alert_button;
    @FindBy(xpath = "//button[@onclick=\"jsConfirm()\"]")
    public WebElement confirm_button;
    @FindBy(xpath = "//button[@onclick=\"jsPrompt()\"]")
    public WebElement prompt_button;
    @FindBy(id = "result")
    WebElement result_text;
    public JavaScriptAltersPage(WebDriver driver) {
        super(driver);
    }
    public void JSAlters()
    {
        alert_button.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();

        confirm_button.click();
        String confirmText = alert.getText();
        Assert.assertEquals(confirmText, "I am a JS Confirm");
        alert.accept();

        prompt_button.click();
        String promptText = alert.getText();
        String EnterText = "Hi, Testing is Fun!";
        alert.sendKeys(EnterText);
        alert.accept();
        Assert.assertEquals(promptText, "I am a JS prompt");
        Assert.assertTrue(result_text.getText().contains(EnterText));
    }
}
