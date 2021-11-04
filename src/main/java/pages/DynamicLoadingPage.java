package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    WebDriver driver;
    String baseUrl = "http://localhost:7080/dynamic_loading";

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    WebElement startButton;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void testHiddenElement(String subUrl) {
        this.driver.navigate().to("http://localhost:7080/dynamic_loading" + subUrl);
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]")));
        this.assertTextContent();
    }

    public void testNewElement(String subUrl) {
        this.driver.navigate().to("http://localhost:7080/dynamic_loading" + subUrl);
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"finish\"]")));
        this.assertTextContent();
    }

    public void assertTextContent() {
        WebElement text = this.driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        Assert.assertEquals("Hello World!", text.getText());
    }
}
