import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesExample.BaseClase;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Tests extends BaseClase {


    @Test
    void loginPositive() {

        setUp("login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("i[class*='signout']")).getText(), "Logout");

        //tearDown();

    }

    @Test
    void loginNegative() {

        setUp("login");

        driver.findElement(By.id("username")).sendKeys("Wrong");
        driver.findElement(By.id("password")).sendKeys("Credentials!");
        driver.findElement(By.cssSelector("button.radius")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).isDisplayed());

       // tearDown();

    }

    @Test
    void checkboxes() {

        setUp("checkboxes ");

        List<WebElement> chexBoxes = new ArrayList<>(driver.findElements(By.xpath("//input[@type='checkbox']")));

        for (WebElement element : chexBoxes) {
            element.click();
            if (element.isSelected()) {
                element.click();
            }

        }

     //   tearDown();

    }

    @Test
    void context_menu() {

        setUp("context_menu ");

        WebElement hot_spot = driver.findElement(By.cssSelector("div#hot-spot"));

        Actions action = new Actions(driver);
        action.contextClick(hot_spot).perform();

        driver.switchTo().alert().accept();

      //  tearDown();

    }

    @Test
    void drag_and_drop() {

        setUp("drag_and_drop ");

        WebElement boxA = driver.findElement(By.cssSelector("div#column-a"));
        WebElement boxB = driver.findElement(By.cssSelector("div#column-b"));

        Actions act = new Actions(driver);
        act.dragAndDrop(boxA, boxB).build().perform();

      //  tearDown();

    }


    @Test
    void dropdown() {

        setUp("dropdown");

        WebElement dropDown = driver.findElement(By.cssSelector("select#dropdown"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Option 2");

      //  tearDown();

    }

    @Test
    void dynamic_content() throws InterruptedException {

        setUp("dynamic_content");

        Thread.sleep(2000);

        driver.navigate().refresh();

      //  tearDown();

    }

    @Test
    void dynamic_controls() {

        setUp("dynamic_controls");

        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"))));
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"))));

     //   tearDown();

    }

    @Test
    void dynamic_loading_2() {

        setUp("dynamic_loading/2");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='example']/div"))));

        driver.findElement(By.xpath("//div[@class='example']/div")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#finish"))));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish")), "Hello World!");


     //   tearDown();

    }

    @Test
    void download() {

        setUp("download");

        driver.findElement(By.xpath("//a[contains(text(),'file.txt')]")).click();

    //    tearDown();

    }

    @Test
    void upload() throws AWTException {

        setUp("upload");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#file-upload")));

        driver.findElement(By.cssSelector("input#file-upload")).sendKeys("C:/Users/Dzianis/Desktop/TextDoc.txt");


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example")).getText(), "File Uploaded!" + "\n" + "TextDoc.txt");

      //  tearDown();

    }

    @Test
    void floating_menu() {

        setUp("floating_menu");

        boolean bool = false;
        if (driver.findElement(By.cssSelector("div.example")).getText().contains("Floating Menu")) {
            bool = true;
        }
        Assert.assertEquals(bool, true);

     //   tearDown();

    }

    @Test
    void iframe() {

        setUp("iframe");

        WebElement frame = driver.findElement(By.cssSelector("iframe[id*='ifr']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("body#tinymce")).clear();
        driver.findElement(By.cssSelector("body#tinymce")).sendKeys("Helloooooooooo!!!");

       // tearDown();

    }

    @Test
    void javascript_alerts() {

        setUp("javascript_alerts");


        WebElement jsAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement jsPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));

        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        jsConfirm.click();
        alert.dismiss();

        jsPrompt.click();
        alert.sendKeys("Aleeeeeeeeert!!!");
        alert.accept();

       // tearDown();

    }

    @Test
    void javascript_error() {

        setUp("javascript_error");


        boolean bool = false;
        if (driver.findElement(By.xpath("//body[@onload='loadError()']/p")).getText().contains("JavaScript error")) {
            bool = true;
        }
        Assert.assertEquals(bool, true);

      //  tearDown();

    }

    @Test
    void windows() {

        setUp("windows");

        String mainWindow = driver.getWindowHandle();
        WebElement click = driver.findElement(By.xpath("//div[@class='example']/a"));
        click.click();

        Set<String> handle= driver.getWindowHandles();
        driver.switchTo().window(mainWindow);

    // tearDown();

    }

    @Test
    void notification_message_rendered() {

        setUp("notification_message_rendered");

       driver.findElement(By.xpath("//a[contains(@href,'message')]")).click();

        boolean bool = false;
        if (driver.findElement(By.id("flash")).getText().contains("Action")) {
            bool = true;
        }
        Assert.assertEquals(bool, true);

    //  tearDown();

    }
}
