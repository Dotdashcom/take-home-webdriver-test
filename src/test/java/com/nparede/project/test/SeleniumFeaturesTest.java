package com.nparede.project.test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite created to concentrate all the tests related to Selenium skills
 */
public class SeleniumFeaturesTest extends  BaseTest {

    private Actions actions = null;
    private FluentWait<WebDriver> wait = null;
    private JavascriptExecutor js = null;


    @BeforeMethod(alwaysRun = true)
    public void setup(){
        actions = new Actions(driver);
        wait    = new WebDriverWait(driver, Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        js      = (JavascriptExecutor) driver;
    }


    @Test(priority = 1)
    public void CheckBoxesTest() {

        // Checkbox1 is unchecked by default, verified, and finally checked.
        WebElement check1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type"));
        boolean checkbox1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();

        if(!checkbox1) {
            check1.click();
            Assert.assertTrue(check1.isSelected());
        }

        // Checkbox2 is checked by default, missing: verified and finally unchecked.
        WebElement check2 = driver.findElement(By.cssSelector("input[type='checkbox']:last-of-type"));
        boolean checkbox2 = driver.findElement(By.cssSelector("input[type='checkbox']:last-of-type")).isSelected();

        if(checkbox2) {
            check2.click();
            Assert.assertFalse(check2.isSelected());
        }
    }


    @Test(priority = 2)
    public void ContextMenuTest() {

        WebElement rightClick = driver.findElement(By.id("hot-spot"));

        actions.contextClick(rightClick).perform();

        Alert alert = driver.switchTo().alert();
        String currentText = alert.getText();
        String expectedText = "You selected a context menu";

        Assert.assertEquals(currentText, expectedText);
    }



    @Test(priority = 3)
    public void DropdownTest() {

        WebElement testDropDown = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(testDropDown);
        // Option 1.
        dropdown.selectByIndex(1);

        WebElement option1 = dropdown.getFirstSelectedOption();
        String currentText = option1.getText();
        String expectedText = "Option 1";

        Assert.assertEquals(currentText, expectedText);

        // Option 2.
        dropdown.selectByIndex(2);

        WebElement option2 = dropdown.getFirstSelectedOption();
        String currentText2 = option2.getText();
        String expectedText2 = "Option 2";

        Assert.assertEquals(currentText2, expectedText2);
    }


    @Test(priority = 4)
    public void DynamicContentTest() {

        int timesToRefresh = 5;

        while (--timesToRefresh!=0) {
            List<WebElement> sectionsBefore = driver.findElements(By.cssSelector("#content > .row"));
            List<String> sectionTextBefore = new ArrayList<>();

            for (WebElement el : sectionsBefore) {
                sectionTextBefore.add(el.getText());
            }

            driver.navigate().refresh();

            List<WebElement> sectionsAfter = driver.findElements(By.cssSelector("#content > .row"));
            List<String> sectionTextAfter = new ArrayList<>();

            for (WebElement el : sectionsAfter) {
                sectionTextAfter.add(el.getText());
            }

            for (int i = 0; i < sectionTextBefore.size(); i++) {
                Assert.assertNotEquals(sectionTextBefore.get(i), sectionTextAfter.get(i), "Error! Text content did not change after refresh.");
            }
        }
    }


    @Test(priority = 5)
    public void DynamicControlsRemoveCheckBoxTest() {

        WebElement removeButton = driver.findElement(By.xpath("//*[text()='Remove']"));
        WebElement checkBox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(checkBox));

        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();
        checkBox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        wait.until(ExpectedConditions.visibilityOf(checkBox));
    }



    @Test(priority = 6)
    public void DynamicControlsEnableTextInputTest() {

        WebElement enableButton = driver.findElement(By.xpath("//*[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("message"),"It's enabled!"));

        WebElement disableButton = driver.findElement(By.xpath("//*[text()='Disable']"));
        disableButton.click();

        wait.until(ExpectedConditions.textToBe(By.id("message"),"It's disabled!"));
    }


    @Test(priority = 7)
    public void DynamicLoadingTest() {

        WebElement buttonStart = driver.findElement(By.xpath("//*[text()='Start']"));
        buttonStart.click();

        wait.until(ExpectedConditions.textToBe(By.id("finish"),"Hello World!"));
    }


    @Test(priority = 8)
    public void MouseHoverTest() {

        WebElement firstAvatar = driver.findElements(By.className("figure")).get(0);
        new Actions (driver).moveToElement(firstAvatar).perform();
        Assert.assertTrue(firstAvatar.findElement(By.xpath("//*[contains(text(),'user1')]")).isDisplayed(), "Error! information not shown.");

        WebElement secondAvatar = driver.findElements(By.className("figure")).get(1);
        new Actions (driver).moveToElement(secondAvatar).perform();
        Assert.assertTrue(secondAvatar.findElement(By.xpath("//*[contains(text(),'user2')]")).isDisplayed(), "Error! information not shown.");

        WebElement thirdAvatar = driver.findElements(By.className("figure")).get(2);
        new Actions (driver).moveToElement(thirdAvatar).perform();
        Assert.assertTrue(thirdAvatar.findElement(By.xpath("//*[contains(text(),'user3')]")).isDisplayed(), "Error! information not shown.");
    }


    @Test(priority = 9)
    public void JavaScriptAlertsJSAlertButtonTest() {

        WebElement buttonJsAlert = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        buttonJsAlert.click();

        Alert alert = driver.switchTo().alert();
        String currentText = alert.getText();
        String expectedText = "I am a JS Alert";

        Assert.assertEquals(currentText, expectedText);
    }


    @Test(priority = 10)
    public void JavaScriptAlertsJSConfirmButtonTest() {

        WebElement buttonJsConfirm = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        buttonJsConfirm.click();

        Alert alert = driver.switchTo().alert();
        String currentText = alert.getText();
        String expectedText = "I am a JS Confirm";

        Assert.assertEquals(currentText, expectedText);
        alert.accept();
    }


    @Test(priority = 11)
    public void  JavaScriptAlertsJsPromptButtonTest() {

        WebElement buttonJsPrompt = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        buttonJsPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("JS Test");
        alert.accept();

        WebElement resultTextShown = driver.findElement(By.id("result"));
        String currentText = resultTextShown.getText();
        String expectedText = "You entered: JS Test";

        Assert.assertEquals(currentText, expectedText);
    }


    @Test(priority = 12)
    public void JavaScriptErrorTest() {

        String text = (String) js.executeScript("try { loadError() } catch(e) { return (e.toString()) }");
        System.out.println(text);

        Assert.assertEquals(text, "TypeError: Cannot read properties of undefined (reading 'xyz')");
    }


    @Test(priority = 13)
    public void OpenInNewTabTest() {

        driver.findElement(By.linkText("Click Here")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        String currentText = driver.findElement(By.cssSelector(".example > h3")).getText();
        String expectedText = "New Window";

        Assert.assertEquals(currentText, expectedText);
    }
}
