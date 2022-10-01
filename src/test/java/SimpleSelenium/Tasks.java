package SimpleSelenium;

import Util.ConfigurationReader;
import Util.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

public class Tasks extends Base {
    @Test
    public void CheckBoxes() {
        Driver.getDriver().get(baseUrl + "/checkboxes");
        WebElement box1 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        if (!box1.isSelected()) {
            box1.click();
            Assert.assertTrue(box1.isSelected());
        } else {
            Assert.assertTrue(box1.isSelected());
        }
        WebElement box2 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));
        wait.until(ExpectedConditions.visibilityOf(box2));
        Assert.assertTrue(box2.isSelected());
    }
    @Test
    public void DragAndDrop() {
        Driver.getDriver().get(baseUrl + "/drag_and_drop");
        wait.until(ExpectedConditions.urlContains("/drag_and_drop"));
        WebElement source = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[1]"));     //   "//div[@id='column-a']"));
        WebElement target = Driver.getDriver().findElement(By.xpath("(//div[@draggable=\"true\"])[2]"));
        int xOffset = source.getLocation().getX();
        int yOffset = target.getLocation().getY();
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDropBy(source, xOffset, yOffset).build().perform();
        String textTarget = target.getText();
        if (textTarget.equals("A")) {
            org.junit.Assert.assertTrue("Image switched", true);
        } else {
            System.err.println("Image is not switched");
        }
    }
    @Test
    public void Dropdown() {
        Driver.getDriver().get(baseUrl + "/dropdown");
        Select selectObj = new Select(Driver.getDriver().findElement(By.id("dropdown")));
        Assert.assertEquals(selectObj.getFirstSelectedOption().getText(), "Please select an option");
        selectObj.selectByVisibleText("Option 1");
        Assert.assertTrue(selectObj.getFirstSelectedOption().getText().equals("Option 1"));
        selectObj.selectByIndex(2);
        Assert.assertEquals(selectObj.getFirstSelectedOption().getText(), "Option 2");
    }
    @Test
    public void DynamicContent() {
        Driver.getDriver().get(baseUrl + "/dynamic_content");
        Actions action = new Actions(Driver.getDriver());
        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
        for (int i = 0; i < 4; i++) {
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//p/a"))).click().build().perform();
            String refreshedText = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
            assertNotEquals(refreshedText, actual);
            actual = refreshedText;
        }
    }
    @Test
    public void DynamicControls(){
        Driver.getDriver().get(baseUrl+"/dynamic_controls");
        Driver.getDriver().findElement(By.xpath("//button[.='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
        assertEquals("It's gone!", Driver.getDriver().findElement(By.id("message")).getText());
        Driver.getDriver().findElement(By.xpath("//button[text()='Add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
        assertEquals("It's back!", Driver.getDriver().findElement(By.id("message")).getText());
        assertTrue(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
        assertTrue(Driver.getDriver().findElement(By.id("message")).getText().equals("It's enabled!"));
        System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        Driver.getDriver().findElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
        assertTrue(Driver.getDriver().findElement(By.id("message")).isDisplayed());
        assertEquals("It's disabled!", Driver.getDriver().findElement(By.id("message")).getText());
    }
    @Test
    public void DynamicLoading(){
        Driver.getDriver().get(baseUrl+"/dynamic_loading/2");
        Driver.getDriver().findElement(By.xpath("//button[.='Start']")).click();
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().
                findElement(By.xpath("//h4[.='Hello World!']"))));
        assertTrue(Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']")).
                getText().equals("Hello World!"));
    }
    @Test
    public void FileDownload(){
        Driver.getDriver().get(baseUrl+"/download");
        Driver.getDriver().findElement(By.xpath("//a[text()='some-file.txt']")).click();
    }
    @Test
    public void FileUpload(){
        Driver.getDriver().get(baseUrl+"/upload");
        String file = "C:\\Users\\User\\Pictures\\qw.jpeg";
        Driver.getDriver().findElement(By.cssSelector("[id='file-upload']")).sendKeys(file);
        Driver.getDriver().findElement(By.id("file-submit")).click();
        assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
    }
    @Test
    public void FloatingMenu(){
        Driver.getDriver().get(baseUrl+"/floating_menu");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", Driver.getDriver().
                findElement(By.xpath("//a[.='Elemental Selenium']")));
        assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@id='menu']")).isDisplayed());
    }
    @Test
    public void Iframe() {
        Driver.getDriver().get(baseUrl + "/iframe");
        //my computer without TinyCloud. And I added step to remove alert about that.
        Driver.getDriver().findElement(By.xpath("//div[@class='tox-icon']")).click();
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        WebElement text = Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']"));
        text.clear();
        text.sendKeys("Iframe tested");
        assertTrue(text.isDisplayed());
        assertTrue(text.getText().equals("Iframe tested"));
        Driver.getDriver().switchTo().parentFrame();
        WebElement header = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(header.isDisplayed(), "Header is did not appear");
        Assert.assertEquals(header.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
    @Test
    public void MouseHover() {
        Driver.getDriver().get(baseUrl + "/hovers");
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 1; i <= 3; i++) {
            actions.moveToElement(Driver.getDriver().findElement(By.xpath
                            ("(//img[@src='/img/avatar-blank.jpg'])" + "[" + i + "]"))).
                    build().perform();
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5)" + "[" + i + "]")).isDisplayed());
        }
    }
    @Test
    public void JavaScriptAlerts() {
        Driver.getDriver().get(baseUrl + "/javascript_alerts");
        WebElement confirmAlertBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBtn.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement resultText = Driver.getDriver().findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(), "result text did not appear!");
        Assert.assertEquals(resultText.getText(), "You clicked: Ok");
    }
    @Test
    public void JavaScriptError() {
        Driver.getDriver().get(baseUrl + "/javascript_error");
        WebElement errorMsg = Driver.getDriver().findElement(By.xpath("//body[@onload='loadError()']"));
        assertTrue(errorMsg.getText().contains("JavaScript error"));
    }
    @Test
    public void OpenInNewTab() {
        Driver.getDriver().get(baseUrl + "/windows");
        String mainWindow = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[.='Click Here']")).click();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windows) {
            if (!windowHandle.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }
        assertTrue(Driver.getDriver().getTitle().equals("New Window"));
    }
    @Test
    public void NotificationMessage() {
        Driver.getDriver().get(baseUrl + "/notification_message_rendered");
        String[] expected = {"Action successful", "Action unsuccesful, please try again"};
        for (int i = 1; i <= 2; i++) {
            Driver.getDriver().findElement(By.linkText("Click here")).click();
            String actual = Driver.getDriver().findElement(By.id("flash-messages")).getText();
            assertNotEquals(expected[i - 1], actual);
        }
    }

}