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


public class DynamicControlsPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
    WebElement switchCheckBoxButton;

    @FindBy(xpath = "//*[@id=\"input-example\"]/button")
    WebElement switchInputButton;


    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/dynamic_controls");
        PageFactory.initElements(driver, this);
    }

    public WebElement findCheckBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkbox\"]")));
        try {
            return this.driver.findElement(By.xpath(""));
        } catch (Exception e) {
            return null;
        }
    }

    public void clickRemove() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        if(switchCheckBoxButton.getText().equals("Remove")) {
            switchCheckBoxButton.click();
        }
    }

    public void clickAdd() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        if(switchCheckBoxButton.getText().equals("Add")) {
            switchCheckBoxButton.click();
        }
    }

    public void assertCheckBox(boolean shouldBeRemoved) {
        //WebElement checkBox = this.findCheckBox();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (shouldBeRemoved) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkbox\"]")));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox\"]")));
        }
    }

    public void clickEnable() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        if(switchInputButton.getText().equals("Enable")) {
            switchInputButton.click();
        }
    }

    public void clickDisable() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        if (switchInputButton.getText().equals("Disable")) {
            switchInputButton.click();
        }
    }

    public void assertInputBox(boolean shouldBeEnabled) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        WebElement inputBox = this.driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        Assert.assertEquals(shouldBeEnabled,inputBox.isEnabled());
    }
}

