package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckboxesPage extends Base {
    WebDriver driver;

    By checkOne = By.xpath(readValue("checkboxesPage.checkboxOneXp"));
    By checkTwo = By.xpath(readValue("checkboxesPage.checkboxTwoXp"));

    public boolean isBoxOneChecked() {
        return driver.findElement(checkOne).isSelected();
    }

    public boolean isBoxTwoChecked() {
        return driver.findElement(checkTwo).isSelected();
    }

    public void clickBoxOne() {
        driver.findElement(checkOne).click();
    }

    public void clickBoxTwo() {
        driver.findElement(checkTwo).click();
    }

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }
}
