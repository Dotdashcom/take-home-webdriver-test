import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage extends PageObject{
    @FindBy(xpath = "//button")
    public WebElement start_button;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void dynamicloading()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        start_button.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

        String Loaded_text = driver.findElement(By.id("finish")).getText();

        Assert.assertEquals(Loaded_text, "Hello World!");

    }

}
