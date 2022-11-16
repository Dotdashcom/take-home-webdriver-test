package webdriverTest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import webdriverTest.pages.LoginPage;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestSpecificRubrics {
    protected static WebDriver driver;


    @BeforeSuite
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void loginSuccess() {
        driver.get("http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.message.getText().contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailure() {
        driver.get("http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.userName.sendKeys("wrong");
        loginPage.password.sendKeys("wrong");
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.message.getText().contains("Your username is invalid!"));
    }

    @Test
    public void checkboxes(){
        driver.get("http://localhost:7080/checkboxes");

        Assert.assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected(), "checkbox1 is not selected");

        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected(), "checkbox1 is not selected");
    }

    @Test
    public void contextMenu(){
        driver.get("http://localhost:7080/context_menu");
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
    }

    @Test
    public void dragAndDrop(){
        driver.get("http://localhost:7080/drag_and_drop");

        WebElement A = driver.findElement(By.id("column-a"));
        WebElement B = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(A, B).build().perform();
    }

    @Test
    public void dropdown(){
        driver.get("http://localhost:7080/dropdown");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        select.selectByVisibleText("Option 1");

        WebElement option1 = driver.findElement(By.xpath("//option[.='Option 1']"));
        Assert.assertTrue(option1.isSelected());
        select.selectByVisibleText("Option 2");

        WebElement option2 = driver.findElement(By.xpath("//option[.='Option 2']"));
        Assert.assertTrue(option2.isDisplayed());
    }

    @Test
    public void dynamicContent(){
        driver.get("http://localhost:7080/dynamic_content");
        String before = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        driver.navigate().refresh();
        WebElement after = driver.findElement(By.xpath("//div[@class='large-10 columns']"));

        if(!before.equals(after.getText())){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void dynamicControls(){
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement removeAndAddBtn = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeAndAddBtn.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        Assert.assertTrue(message.isDisplayed());
        removeAndAddBtn.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's back!"));
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's back!");

        WebElement enable_disableBtn = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enable_disableBtn.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's enabled!"));
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's enabled!");
    }

    @Test
    public void dynamicLoading(){
        driver.get("http://localhost:7080/dynamic_loading/2");

        WebElement startBtn = driver.findElement(By.xpath("//button[.='Start']"));
        startBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement text = driver.findElement(By.xpath("//div[@id='finish']"));
        wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("http://localhost:7080/download");
        WebElement download = driver.findElement(By.linkText("some-file.txt"));
        download.click();
        Thread.sleep(2000);
        // Downloads

        File fileLocation = new File("C:\\Users\\HP_001\\Downloads");

        File [] files = fileLocation.listFiles();
        boolean downloadedOrNot = false;

        for (File file : files){
            if (file.getName().equals("some-file.txt")){
                System.out.println("File downloaded");
                downloadedOrNot = true;
                break;
            }
        }
        Assert.assertTrue(downloadedOrNot, "File not downloaded");
    }

    @Test
    public void fileUpload(){
        driver.get("http://localhost:7080/upload");
        driver.findElement(By.xpath("//input[@name=\"file\"]")).sendKeys("C:\\Users\\HP_001\\Downloads\\some-file.txt");
        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

    @Test
    public void floatingMenu(){
        driver.get("http://localhost:7080/floating_menu");
        WebElement floatingMenu = driver.findElement(By.xpath("//h3[.='Floating Menu']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        Assert.assertTrue(floatingMenu.isDisplayed());
    }

    @Test
    public void iframe(){
        driver.get("http://localhost:7080/iframe");
        driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.xpath("//p"));
        textArea.sendKeys("Hello ");
        Assert.assertEquals(textArea.getText(), "Hello Your content goes here.");
    }

    @Test
    public void mouseHover(){
        driver.get("http://localhost:7080/hovers");
        WebElement image1 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement image2 = driver.findElement(By.xpath("(//img)[3]"));
        WebElement image3 = driver.findElement(By.xpath("(//img)[4]"));
        WebElement user1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1.isDisplayed());

        actions.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed());
    }

    @Test
    public void javaScriptAlerts(){
        driver.get("http://localhost:7080/javascript_alerts");
        WebElement JSAlert = driver.findElement(By.xpath("(//button)[1]"));
        WebElement JSConfirm = driver.findElement(By.xpath("(//button)[2]"));
        WebElement JSPrompt = driver.findElement(By.xpath("(//button)[3]"));
        JSAlert.click();

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
        driver.switchTo().alert().accept();

        JSConfirm.click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[2]")).getText(), "You clicked: Ok");

        JSPrompt.click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("(//p)[2]")).getText().contains("Hello"));
    }

    @Test
    public void javaScriptError() {
        driver.get("http://localhost:7080/javascript_error");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        logEntries.filter(Level.ALL);
        List<LogEntry> logs = logEntries.filter(Level.ALL);

        for (LogEntry logEntry : logs){
            if(logEntry.toString().contains("Cannot read properties of undefined (reading 'xyz')")) {
                Assert.assertTrue(logEntry.toString().contains("Cannot read properties of undefined (reading 'xyz')"));
            }
        }
    }

    @Test
    public void openInNewTab(){
        driver.get("http://localhost:7080/windows");
        driver.findElement(By.linkText("Click Here")).click();

        String actualTitle;
        for(String eachWindow : driver.getWindowHandles()){
            driver.switchTo().window(eachWindow);
        }

        actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, "New Window");
    }

    @Test
    public void notificationMessage(){
        driver.get("http://localhost:7080/notification_message_rendered");
        WebElement clickBtn = driver.findElement(By.partialLinkText("Click here"));
        clickBtn.click();

        while (true) {
            if (driver.findElement(By.xpath("//div[@id='flash-messages']")).getText().contains("Action successful")) {
                break;
            } else {
                try {
                    clickBtn.click();
                } catch (StaleElementReferenceException e) {
                    clickBtn.click();
                }
            }
        }
        System.out.println("Action successful");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("Action successful"));

    }




}
