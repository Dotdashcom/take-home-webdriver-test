package framework.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
    WebDriver driver;
    WebDriverWait wait;

    public DynamicLoadingPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    @FindBy(xpath ="//*[@id = 'start']/button")
    WebElement start;

    @FindBy(xpath = "//*[@id='finish']/h4")
    WebElement helloWorldText;

    public void verifyLoadedText(){
        start.click();
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        Assert.assertEquals("Hello World!", helloWorldText.getText());

    }



}
