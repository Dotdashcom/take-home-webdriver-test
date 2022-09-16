package faridun.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Base {

    public Base() {
        PageFactory.initElements(TestBase.driver, this);
    }

    // common methods across all pages

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement click) {
        click.click();
    }

    public static void clickCheckbox(WebElement checkbox) {
        if (checkbox.isDisplayed() && !checkbox.isSelected()) {
            checkbox.click();
            System.out.println("checks unchecked checkboxes");
        } else {
            checkbox.click();
            System.out.println("unchecks checked checkboxes");
        }
    }

    public static void rightClick(WebElement element) {
        Actions actions = new Actions(TestBase.driver);
        actions.contextClick(element).perform();
    }

    public static void verifyPopup(String alertMSg) {
        Alert alert = TestBase.driver.switchTo().alert();
        String alertMessage = TestBase.driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage, alertMessage);
        alert.accept();
    }


}
