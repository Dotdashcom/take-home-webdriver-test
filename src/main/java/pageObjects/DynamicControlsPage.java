package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends Base {
    WebDriver driver;

    By removeButton = By.xpath(readValue("dynamicControlsPage.removeButtonXp"));
    By addButton = By.xpath(readValue("dynamicControlsPage.addButtonXp"));
    By enableButton = By.xpath(readValue("dynamicControlsPage.enableButtonXp"));
    By disableButton = By.xpath(readValue("dynamicControlsPage.disableButtonXp"));
    By checkbox = By.xpath(readValue("dynamicControlsPage.checkboxXp"));
    By inputField = By.xpath(readValue("dynamicControlsPage.inputFieldXp"));
    By message = By.xpath(readValue("dynamicControlsPage.messageXp"));

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
    }

    public boolean isCheckboxDisplayed() {
        try {
            return driver.findElement(checkbox).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
    }

    public void clickEnableButton() {
        driver.findElement(enableButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
    }

    public boolean isInputFieldEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

    public void clickDisableButton() {
        driver.findElement(disableButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
    }

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }
}
