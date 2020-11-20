package specs.DynamicControls;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #8 Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits
public class CheckDynamicControls extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static WebDriverWait wait;
    private static By byRemove = By.xpath("//button[contains(text(), 'Remove')]");
    private static By byAdd = By.xpath("//button[contains(text(), 'Add')]");
    private static By byEnable = By.xpath("//button[contains(text(), 'Enable')]");
    private static By byDisable = By.xpath("//button[contains(text(), 'Disable')]");
    private static By byChBox = By.xpath("//div[@id='checkbox']");
    private static By byChBoxBack = By.xpath("//div/input[@id='checkbox']");
    private static By byTxtBox = By.xpath("//input[@type = 'text']");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/dynamic_controls");
        wait = new WebDriverWait(driver, 15);
    }

    @Test(priority = 1, enabled = true)
    public void checkChBoxIsGone() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Thread.sleep(DEFAULT_PAUSE);

        Boolean exist; // CheckBox exists

        // Remove a CheckBox
        driver.findElement(byRemove).click();

        try {
            exist = wait.until(ExpectedConditions.invisibilityOfElementLocated(byChBox));
        } catch (TimeoutException e) {
            exist = false;
        }

        // Validate a checkbox element has been removed
        softas.assertTrue(exist, "A checkbox element still exists");

        softas.assertAll();
    }

    @Test(priority = 2, enabled = true)
    public void checkChBoxIsBack() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Thread.sleep(DEFAULT_PAUSE);

        // Remove a CheckBox
        driver.findElement(byAdd).click();

        String chType = "";
        String expText = "checkbox";

        try {
            WebElement exist = wait.until(ExpectedConditions.visibilityOfElementLocated(byChBoxBack));
            chType = exist.getAttribute("type");
        } catch (TimeoutException e) {
            System.out.println("A checkbox element still doesn't exist");
        }

        // Validate a checkbox element has been removed
        softas.assertTrue(expText.equals(chType), "A checkbox element still doesn't exist");

        softas.assertAll();
    }

    @Test(priority = 3, enabled = true)
    public void checkTxtBoxIsEnabled() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Thread.sleep(DEFAULT_PAUSE);

        Boolean enabled = false; // TextBox is disabled

        // Enable a TextBox
        driver.findElement(byEnable).click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(byTxtBox));
            enabled = true;
        } catch (TimeoutException e) {
            System.out.println("TextBox element is still disabled");
        }

        // Validate a textbox element has been enabled
        softas.assertTrue(enabled, "TextBox element is still disabled");

        softas.assertAll();
    }

    @Test(priority = 4, enabled = true)
    public void checkTxtBoxIsDisabled() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Thread.sleep(DEFAULT_PAUSE);

        Boolean enabled = true; // TextBox is enabled

        // Disable a TextBox
        driver.findElement(byDisable).click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(byEnable));
            wait.until(ExpectedConditions.elementToBeClickable(byTxtBox));
            System.out.println("TextBox element is still enabled");
        } catch (TimeoutException e) {
            enabled = false;
        }

        // Validate a textbox element has been disabled
        softas.assertFalse(enabled, "TextBox element is still enabled");

        softas.assertAll();
    }

}
