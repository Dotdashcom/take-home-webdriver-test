package test1;

import PageObjectModel.loginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import utilities.Driver;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class testClass {

    WebDriver driver;


    loginPage lg = new loginPage();

    @AfterSuite
    public void quiteDriver() {
        driver.quit();
    }


    @AfterTest
    public void quitMethode() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test(priority = 1)
    public void loginTest(){
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/login");
        lg.typeUsername();
        lg.typePassword();
        lg.clickOnLogin();
        lg.assertionMethode();
    }

    @Test(priority = 2)
    public void negativeLoginTest()  {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/login");

        lg.typeInvalidUsername();
        lg.typePassword();
        lg.clickOnLogin();
        lg.assertionMethodeNegative();


    }

    @Test(priority = 3)
    public void checkboxTest()  {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[1]"));
        checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[2]"));

        checkBox2.click();

        List<WebElement> elements = driver.findElements(By.xpath("//input[@checked]"));


        Assert.assertTrue(elements.get(0).isDisplayed());
        Assert.assertFalse(elements.size() == 2);


    }

    @Test(priority = 4)
    public void contextMenu() {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/context_menu");

        Actions action = new Actions(driver);
        WebElement rightClickBox = driver.findElement(By.id("hot-spot"));
        action.contextClick(rightClickBox).perform();

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage.trim(), "You selected a context menu");

        driver.switchTo().alert().accept();

    }

    @Test(priority = 5)
    public void dragAndDrop() {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/drag_and_drop");

        WebElement dragDrop_A = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement dragDrop_B = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

//        Actions act=new Actions(driver);
//        act.dragAndDrop(dragDrop_B,dragDrop_A).perform();
        //Above code suppose to work but on html5 automatic dragging is not supported. I had to find a Js code for it.

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String dragAndDropScript =
                "var source = arguments[0];" +
                        "var target = arguments[1];" +
                        "const dataTransfer = new DataTransfer();" +
                        "const dragstartEvent = new DragEvent('dragstart', { dataTransfer });" +
                        "source.dispatchEvent(dragstartEvent);" +
                        "target.dispatchEvent(new DragEvent('dragenter', { dataTransfer }));" +
                        "target.dispatchEvent(new DragEvent('dragover', { dataTransfer }));" +
                        "target.dispatchEvent(new DragEvent('drop', { dataTransfer }));" +
                        "source.dispatchEvent(new DragEvent('dragend', { dataTransfer }));";

        jsExecutor.executeScript(dragAndDropScript, dragDrop_B, dragDrop_A);


        Assert.assertEquals(dragDrop_A.getText(), "B");
        Assert.assertEquals(dragDrop_B.getText(), "A");

    }


    @Test(priority = 6)
    public void dropDown(){
        driver = Driver.getDriver();
        driver.get(" http://localhost:7080/dropdown");
        WebElement dropdown = driver.findElement(By.cssSelector("select#dropdown"));

        Select slc = new Select(dropdown);

        slc.selectByIndex(1);

        WebElement option1 = driver.findElement(By.xpath("(//select[@id='dropdown']/option)[2][@selected]"));

        Assert.assertTrue(option1.isSelected());

        slc.selectByIndex(2);

        WebElement option2 = driver.findElement(By.xpath("(//select[@id='dropdown']/option)[3][@selected]"));

        Assert.assertTrue(option2.isSelected());
    }


    @Test(priority = 7)
    public void DynamicContent() {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/dynamic_content");


        for (int i = 0; i < 3; i++) {
            String a = driver.getPageSource();
            driver.navigate().refresh();
            Assert.assertNotEquals(a, driver.getPageSource());

        }

    }

    @Test(priority = 8)
    public void DynamicControls()  {

        driver = Driver.getDriver();
        driver.get("http://localhost:7080/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("gone"));

        WebElement dynamicControlsAdd = driver.findElement(By.xpath("//button[text()='Add']"));
        dynamicControlsAdd.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("back"));

        WebElement dynamicControlsEnable = driver.findElement(By.xpath("//button[text()='Enable']"));
        dynamicControlsEnable.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("enabled"));

        WebElement dynamicControlsDisable = driver.findElement(By.xpath("//button[text()='Disable']"));
        dynamicControlsDisable.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("disabled"));
    }

    @Test(priority = 9)
    public void dynamicLoading()  {

        driver = Driver.getDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dynamicLoadingStart = driver.findElement(By.xpath("//button[text()='Start']"));
        dynamicLoadingStart.click();
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertTrue(until.getText().contains("Hello World!"));
    }

    @Test(priority = 10)
    public void fileDownload() throws InterruptedException {
        Map<String, Object> chromPref = new HashMap<>();
        chromPref.put("download.default_directory", System.getProperty("user.dir") + "\\src\\test\\resources\\downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromPref);

        driver = new ChromeDriver(options);
        driver.get("http://localhost:7080/download");
        WebElement fileToDwnload = driver.findElement(By.xpath("//a[text()='some-file.txt']"));
        fileToDwnload.click();

        String fileName = fileToDwnload.getText().trim();

        Thread.sleep(2000);
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\downloads\\" + fileName);
        assert file.exists();
        file.delete();
    }

    @Test(priority = 11)
    public void fileUpload() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\some-file.txt");

        WebElement fileSubmit = driver.findElement(By.id("file-submit"));
        fileSubmit.click();

        WebElement successMsg = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Thread.sleep(1000);
        Assert.assertTrue(successMsg.getText().contains("Uploaded"));
    }

    public boolean isElementVisibleInViewport(WebElement element) {//belongs to following test
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int elemTop = ((Number) js.executeScript("return arguments[0].offsetTop;", element)).intValue();//4432
        //System.out.println( elemTop);
        int scrollTop = ((Number) js.executeScript("return (window.pageYOffset !== undefined) ? window.pageYOffset : (document.documentElement || document.body.parentNode || document.body).scrollTop;")).intValue(); // 4469.33349609375
        //System.out.println( scrollTop);
        int elemBottom = elemTop + element.getSize().getHeight();// 4432+42 =4474
        //System.out.println( elemBottom);
        int windowHeight = ((Number) js.executeScript("return window.innerHeight;")).intValue(); // 740
        //System.out.println( windowHeight);
        return (elemTop >= scrollTop - windowHeight) && (elemBottom <= (scrollTop + windowHeight));
    }

    @Test(priority = 12)
    public void floatingMenu() {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/floating_menu");
        driver.manage().window().maximize();


        WebElement menu = driver.findElement(By.cssSelector("div#menu"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        assert isElementVisibleInViewport(menu);

    }

    @Test(priority = 13)
    public void iFrame() {

        driver = Driver.getDriver();
        driver.get("http://localhost:7080/iframe");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        WebElement content = driver.findElement(By.id("mce_0_ifr"));
        WebElement warning = driver.findElement(By.xpath("//*[contains(@class,'tox-notification__dismiss')]"));
        warning.click();
        driver.switchTo().frame(content);
        WebElement txtbox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        txtbox.clear();
        txtbox.sendKeys("Ender Bahar");

        WebElement writtenTxt = driver.findElement(By.xpath("//body[@id='tinymce']"));

        Assert.assertEquals(writtenTxt.getText(), "Ender Bahar");
    }

    @Test(priority = 14)
    public void mouseHover() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/hovers");
        WebElement figure1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement figure2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement figure3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        Actions act = new Actions(driver);

        act.moveToElement(figure1).perform();
        WebElement addInf1 = driver.findElement(By.xpath("//*[@href='/users/1' and text()='View profile']"));
        assert addInf1.isDisplayed();
        Thread.sleep(1000);
        act.moveToElement(figure2).perform();
        WebElement addInf2 = driver.findElement(By.xpath("//*[@href='/users/2' and text()='View profile']"));
        assert addInf2.isDisplayed();
        Thread.sleep(1000);
        act.moveToElement(figure3).perform();
        WebElement addInf3 = driver.findElement(By.xpath("//*[@href='/users/3' and text()='View profile']"));
        assert addInf3.isDisplayed();

    }

    @Test(priority = 15)
    public void javaScriptAlerts()  {


        driver = Driver.getDriver();
        driver.get("http://localhost:7080/javascript_alerts");

        //first button
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        Alert alt = driver.switchTo().alert();
        Assert.assertEquals(alt.getText(), "I am a JS Alert");
        alt.accept();

        driver.switchTo().defaultContent();
        //second button
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        alt = driver.switchTo().alert();
        Assert.assertEquals(alt.getText(), "I am a JS Confirm");
        alt.accept();

        driver.switchTo().defaultContent();
        //third button
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        alt.sendKeys("Ender");
        alt.accept();
        driver.switchTo().defaultContent();
        WebElement verifyTxt = driver.findElement(By.cssSelector("#result"));

        assert verifyTxt.getText().equals("You entered: Ender");
    }

    @Test(priority = 16)
    public void testJavaScriptConsoleError() throws InterruptedException {
        driver = Driver.getDriver();
        Thread.sleep(1000);
        driver.get("http://localhost:7080/javascript_error");

        // Retrieve JavaScript console logs
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Thread.sleep(1000);
        boolean errorFound = false;
        String errorMsg = "Cannot read properties of undefined (reading 'xyz')";
        Thread.sleep(1000);
        for (LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
            if (entry.getMessage().contains(errorMsg)) {
                errorFound = true;
                break;
            }
        }

        Assert.assertTrue(errorFound, "Expected JavaScript error not found in the console: " + errorMsg);
    }

    @Test(priority = 17)
    public void openInNewTab()  {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/windows");
        String mainPageTitle = driver.getTitle();
        String mainGuid = driver.getWindowHandle();
        WebElement newTab = driver.findElement(By.xpath("//a[text()='Click Here']"));
        newTab.click();
        Set<String> guids = driver.getWindowHandles();
        for (String guid : guids) {
            if (!guid.equals(mainGuid)) {
                driver.switchTo().window(guid);
            }
        }
        Assert.assertEquals(driver.getTitle(), "New Window");
    }

    @Test(priority = 18)
    public void notificationMessage() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("http://localhost:7080/notification_message_rendered");


        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click here']"));
        clickHere.click();


        WebElement message = driver.findElement(By.cssSelector("div#flash"));
        if (message.getText().contains("Action unsuccesful, please try again") || message.getText().contains("Action successful")) {
            assert true;
            System.out.println(message.getText());

        } else
            assert false;


        driver.navigate().refresh();
        Thread.sleep(2000);


        WebElement click2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        click2.click();


        WebElement message2 = driver.findElement(By.cssSelector("div#flash"));
        if (message2.getText().contains("Action unsuccesful, please try again") || message2.getText().contains("Action successful")) {
            assert true;
            System.out.println(message2.getText());

        } else
            assert false;
    }
}
