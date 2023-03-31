package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {
    public DynamicControl(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    WebElement removeAddButton;
    @FindBy(id = "checkbox")
    WebElement checkBox;
    @FindBy(xpath = "//input[@type='text']")
    WebElement inputField;
    @FindBy(xpath = "//button[@onclick='swapInput()']")
    WebElement enableDisable;
    @FindBy(xpath = "//button[.='Disable']")
    WebElement textOnButton;

    public void clickRemoveButton(WebDriver driver) {
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement itsGoneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
    }

    //    public boolean isCheckboxNotDisplayed(){
//
//        return checkBox.isDisplayed();
//    }
    public void clickAddButton(WebDriver driver) {
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.=' A checkbox']")));
    }

    public boolean isCheckboxDisplayed() {

        return checkBox.isDisplayed();
    }

    public void clickEnable(WebDriver driver) {
        enableDisable.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itsBackMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    }

    public boolean isBoxEnable() {
        return inputField.isEnabled();
    }


    public void clickDisable(WebDriver driver) {
        enableDisable.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath("//button[.='Disable']"))));
    }

    public boolean isBoxDisable() {
        return inputField.isEnabled();
    }


}





