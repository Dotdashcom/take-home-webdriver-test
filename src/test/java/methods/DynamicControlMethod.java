package methods;

import model.DynamicControlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class DynamicControlMethod extends GeneralTestMethod{

    private final String dynamicControlURL = "http://localhost:7080/dynamic_controls";
    DynamicControlPage dynamicControlPage;

    public void startDynamicControlTest() {
        driver.get(dynamicControlURL);
        dynamicControlPage = new DynamicControlPage(driver);

        // checkbox tests
        WebElement removeAddbutton = dynamicControlPage.removeAddComponent();
        clickRemove(removeAddbutton);
        assertFalse(isCheckboxPresent(),"checkbox present");
        clickAdd(removeAddbutton);
        assertTrue(isCheckboxPresent(),"checkbox not present");

        // textbox tests
        WebElement button = dynamicControlPage.disableEnableComponent();
        WebElement textbox = dynamicControlPage.textComponent();
        clickEnable(button, textbox);
        assertTrue(isTextboxEnable(textbox), "textbox disabled");
        clickDisable(button, textbox);
        assertFalse(isTextboxEnable(textbox), "textbox enabled");

    }

    public boolean isCheckboxPresent() {
        return (dynamicControlPage.checkboxComponents() > 0);
    }

    public boolean isTextboxEnable(WebElement textbox) {
        return textbox.isEnabled();
    }

    public void clickRemove(WebElement button) {
        button.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
    }

    public void clickAdd(WebElement button) {
        button.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
    }

    public void clickEnable(WebElement button, WebElement textbox) {
        button.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(textbox));
    }

    public void clickDisable(WebElement button, WebElement textbox) {
        button.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(not(ExpectedConditions.elementToBeClickable(textbox)));
    }

}
