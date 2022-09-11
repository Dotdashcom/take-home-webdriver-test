package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DynamicLoading {

    public DynamicLoading(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLoadingPage;

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    WebElement example1;

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    WebElement example2;

    @FindBy(xpath = "//button")
    WebElement startButton;

    @FindBy(xpath = "//div[@id='finish']//following::h4")
    WebElement helloWorld;

    @FindBy(xpath = "//div[@id='finish']//h4")
    WebElement helloWorld2;

    public void getHidden(WebDriver driver) throws InterruptedException {
        dynamicLoadingPage.click();
        example1.click();
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertEquals(helloWorld.getText(),"Hello World!");
    }

    public void getRendered(WebDriver driver){
        driver.navigate().back();
        example2.click();
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(helloWorld2));
        Assert.assertEquals(helloWorld2.getText(),"Hello World!");
    }
}
