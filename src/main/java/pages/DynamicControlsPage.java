package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DynamicControlsPage extends BasicPage {
    WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/dynamic_controls");
        PageFactory.initElements(driver, this);
    }

    public WebElement findCheckBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));
        try {
            return this.driver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
        } catch (Exception e) {
            return null;
        }
    }

    public void clickRemove() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        removeButton.click();
    }

    public void clickAdd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        removeButton.click();
    }

    public void assertCheckBox(boolean shouldBeRemoved) {
        WebElement checkBox = this.findCheckBox();
        if (shouldBeRemoved) {
            Assert.assertNull(checkBox);
        } else {
            Assert.assertNotNull(checkBox);
        }
    }
}

