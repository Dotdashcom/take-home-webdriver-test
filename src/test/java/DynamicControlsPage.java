import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DynamicControlsPage extends PageObject
{
    @FindBy(xpath = "//button[@onclick=\"swapCheckbox()\"]")
    public WebElement remove_button;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    public WebElement checkbox;

    @FindBy(xpath = "//button[@onclick=\"swapInput()\"]")
    public WebElement enable_button;
    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement text_box;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void dynamicControls()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        remove_button.click();
        wait.until(ExpectedConditions.textToBePresentInElement(remove_button, "Add"));

        Assert.assertTrue(checkbox.isDisplayed());

        remove_button.click();
        wait.until(ExpectedConditions.textToBePresentInElement(remove_button, "Remove"));

        Assert.assertTrue(checkbox.isDisplayed());

        enable_button.click();
        wait.until(ExpectedConditions.textToBePresentInElement(enable_button, "Disable"));

        Assert.assertTrue(text_box.isEnabled());

        enable_button.click();
        wait.until(ExpectedConditions.textToBePresentInElement(enable_button, "Enable"));

        Assert.assertFalse(text_box.isEnabled());
    }

}
