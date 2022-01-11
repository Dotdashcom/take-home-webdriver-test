package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {
    WebDriver driver;
    String dynamicControlsUrl = ("http://localhost:7080/dynamic_controls");
    String removeButtonXpath = "//button[text()='Remove']";
    String addButtonXpath = "//button[text()='Add']";
    String enableButtonXpath = "//button[text()='Enable']";
    String disableButtonXpath = "//button[text()='Disable']";
    String textBoxXpath = "//input[@type='text']";
    By checkBoxId = By.id("checkbox");


    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(dynamicControlsUrl);
    }

    public void clickRemoveButton(){
        WebElement removeButton = driver.findElement(By.xpath(removeButtonXpath));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxId));
    }

    public void clickAddButton(){
        WebElement addButton = driver.findElement((By.xpath(addButtonXpath)));
        addButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxId));
    }

    public void clickEnableButton(){
        WebElement enableButton = driver.findElement(By.xpath(enableButtonXpath));
        enableButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(disableButtonXpath)));
    }

    public void clickDisableButton(){
        WebElement disableButton = driver.findElement(By.xpath(disableButtonXpath));
        disableButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(enableButtonXpath)));
    }

    public boolean isCheckBoxPresent(){
        if (driver.findElements(checkBoxId).size() > 0) return true;
        else return false;
    }

    public boolean isTextBoxEnabled(){
        return driver.findElement(By.xpath(textBoxXpath)).isEnabled();
    }

}
