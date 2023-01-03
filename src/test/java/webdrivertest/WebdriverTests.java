package webdrivertest;


import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.LoginPage;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebdriverTests {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void initiateDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void driverQuit() {
        driver.quit();
    }

    String baseUrl = "http://localhost:7080";

   @Test(priority = 1)
    public void loginSuccess(){
        String url = baseUrl + "/" + "login";
        driver.get(url);
        driver.manage().window().maximize();
        loginPage.username.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();
        String expectedValue = "Secure Area";
        String actualValue = loginPage.secureArea.getText();
        Assert.assertEquals(actualValue, expectedValue, "User doesn't logged in successfully");
    }

    @Test(priority = 2)
    public void loginFailure() {
        String url = baseUrl + "/" + "login";
        driver.get(url);
        driver.manage().window().maximize();
        loginPage.username.sendKeys("tomsmi");
        loginPage.password.sendKeys("SuperSecretPassw");
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.invalidlogin.getText().contains("Your username is invalid!"), "User has logged in successfully");
    }

   @Test(priority = 3)
    public void checkboxes() throws InterruptedException {
        String url = baseUrl + "/" + "checkboxes";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        checkbox2.click();
        Thread.sleep(2000);
        checkbox1.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkbox1.isSelected());
        checkbox1.click();
        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkbox2.isSelected());
    }

   @Test(priority = 4)
    public void contextMenu() {
        String url = baseUrl + "/" + "context_menu";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement contextMenu = driver.findElement(By.id("hot-spot"));
        Actions act = new Actions(driver);
        act.contextClick(contextMenu).perform();
        Alert contextAlert = driver.switchTo().alert();
        String expectedText = "You selected a context menu";
        String actualText = contextAlert.getText();
        Assert.assertEquals(actualText,expectedText,"The alert menu text does not match");
        contextAlert.accept();
    }

   @Test(priority = 5)
    public void dragAndDrop() throws InterruptedException {
        String url = baseUrl + "/" + "drag_and_drop";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement fromA = driver.findElement(By.id("column-a"));
        WebElement toB = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        act.dragAndDrop(fromA, toB).perform();
//        Action dragAndDrop = act.clickAndHold(fromA).moveToElement(toB).release(toB).build();
//        dragAndDrop.perform();

        Assert.assertEquals(fromA.getText(), "B", "FAIL: File couldn't be dropped to target as expected");
        Assert.assertEquals(toB.getText(), "A", "FAIL: File couldn't be dropped to target as expected");
        Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void dropdown(){
        String url = baseUrl + "/" + "dropdown";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        WebElement option1 = driver.findElement(By.xpath("//div[@id='content']/div/select/option[@value='1']"));
        WebElement option2 = driver.findElement(By.xpath("//div[@id='content']/div/select/option[@value='2']"));
        Select dropdown = new Select(dropdownElement);
        dropdownElement.click();
        option1.click();
        Assert.assertTrue(option1.isSelected(), "Option 1 is not selected");
        option2.click();
        Assert.assertTrue(option2.isSelected(), "Option 2 is not selected");
    }

   @Test(priority = 7)
    public void dynamicContent(){
        String url = baseUrl + "/" + "dynamic_content";
        driver.get(url);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebElement textA = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
        String firstContent = textA.getText();
        driver.navigate().refresh();
        WebElement textB = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
        String secondContent = textB.getText();
        Assert.assertNotEquals(firstContent, secondContent,"Content is not changing");

    }

    @Test(priority = 8)
    public void dynamicControls(){
        String url = baseUrl + "/" + "dynamic_controls";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expected = "It's gone!";
        String actual = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actual,expected, "the checkbox is not gone.");
        WebElement addButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        addButton.click();
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkbox']")));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());
        WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        enableButton.click();
        WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled());
        WebElement disableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        disableButton.click();
        WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='input-example']/input")).isDisplayed());

    }

    @Test(priority = 9)
    public void dynamicLoading(){
        String url = baseUrl + "/" + "dynamic_loading/2";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement  startButton = driver.findElement(By.xpath("//*[@id='start']/button"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
        WebElement helloWorld = driver.findElement(By.xpath("//*[@id='finish']/h4"));
        Assert.assertTrue(helloWorld.isDisplayed());
    }

    @Test(priority = 10)
    public void fileDownload() throws InterruptedException {
        String url = baseUrl + "/" + "download";
        driver.get(url);
        driver.manage().window().maximize();
        String downloadPath = FileUtils.getUserDirectoryPath();
        File downloadDirectory = new File(downloadPath, "Downloads");

        WebElement file = driver.findElement(By.xpath("//*[@id='content']/div/a"));
        file.click();
        Thread.sleep(2000);
        File addfilename = new File(downloadDirectory, file.getText());//path with file name
        System.out.println(addfilename.getAbsolutePath());
        Assert.assertTrue(addfilename.exists());
    }

    @Test(priority = 11)
    public void fileUpload() throws InterruptedException {
        String url = baseUrl + "/" + "upload";
        driver.get(url);
        driver.manage().window().maximize();
        String downloadPath = FileUtils.getUserDirectoryPath();
        File downloadDirectory = new File(downloadPath,"Downloads");
        String fileName = "some-file.txt";
        File fileUpload = new File(downloadDirectory,fileName);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(fileUpload.getAbsolutePath());
        Thread.sleep(5000);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(5000);
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadedFile.isDisplayed());

    }

    @Test(priority = 12)
    public void floatingMenu() throws InterruptedException {
        String url = baseUrl + "/" + "floating_menu";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement floatingMenu = driver.findElement(By.id("menu"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        Assert.assertTrue(floatingMenu.isDisplayed());

    }

    @Test(priority = 13)
    public void iFrame() throws InterruptedException {
        String url = baseUrl + "/" + "iframe ";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/button")).click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement textFrame = driver.findElement(By.id("tinymce"));
        textFrame.clear();
        textFrame.sendKeys("Hello World!");
        Thread.sleep(2000);
        String expectedText = "Hello World!";
        String actualText = textFrame.getText();
        Assert.assertEquals(actualText, expectedText,"Typed text is not as expected");
    }

    @Test(priority = 14)
    public void mouseHover() throws InterruptedException {
        String url = baseUrl + "/" + "hovers";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        WebElement user2 = driver.findElement(By.xpath("//*[@id='content']/div/div[2]"));
        WebElement user3 = driver.findElement(By.xpath("//*[@id='content']/div/div[3]"));
        act.moveToElement(user1).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).isDisplayed());
        Thread.sleep(2000);
        act.moveToElement(user2).perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5")).isDisplayed());
        act.moveToElement(user3).perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5")).isDisplayed());
    }


    @Test(priority = 15)
    public void javaScriptAlerts(){
        String url = baseUrl + "/" + "javascript_alerts";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement jsAlertButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
        jsAlertButton.click();
        Alert jsAlert = driver.switchTo().alert();
        String alertMessage = jsAlert.getText();
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"));
        jsAlert.accept();
        WebElement jsConfirmButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfirmButton.click();
        Alert jsConfirm = driver.switchTo().alert();
        String confirmMessage = jsConfirm.getText();
        Assert.assertTrue(confirmMessage.equals("I am a JS Confirm"));
        jsConfirm.accept();
        WebElement jsPromptButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptButton.click();
        Alert jsPrompt = driver.switchTo().alert();
        jsPrompt.sendKeys("Hello World!");
        String promptMessage = jsPrompt.getText();
        Assert.assertTrue(promptMessage.equals("I am a JS prompt"));
        jsPrompt.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).getText().contains("Hello World!"));
    }



   @Test(priority = 16)
    public void javaScriptError() {
        String url = baseUrl + "/" + "javascript_error";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/p"));
        System.out.println(errorMessage.getText());
        String expectedError = "Cannot read property 'xyz' of undefined.";
        String actualError = errorMessage.getText();
        Assert.assertEquals(actualError,expectedError, "error message does not match");
    }


    @Test(priority = 17)
    public void openNewTab() {
        String url = baseUrl + "/" + "windows";
        driver.get(url);
        driver.manage().window().maximize();
        String mainGUID = driver.getWindowHandle();
        WebElement clickHere = driver.findElement(By.xpath("//*[@id='content']/div/a"));
        clickHere.click();
        Set <String> allGUIDS = driver.getWindowHandles();
        for (String guid : allGUIDS){
            driver.switchTo().window(guid);
        }
        String expectedText = "New Window";
        String actualText = driver.findElement(By.xpath("/html/body/div/h3")).getText();
        Assert.assertEquals(actualText, expectedText, "The text at new tab does not match");

    }


    @Test(priority = 18)
    public void notificationMessage() throws InterruptedException {
        String url = baseUrl + "/" + "notification_message_rendered";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        for (int i = 0; i < 5; i++) {
            WebElement clickButton = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
            clickButton.click();
            Thread.sleep(2000);
        }
        WebElement actionMessage = driver.findElement(By.xpath("//*[@id='flash']"));
        Assert.assertTrue(actionMessage.getText().contains("Action successful")
                || actionMessage.getText().contains("Action unsuccesful, please try again")
                || actionMessage.getText().contains("Action Unsuccessful"));

    }


}
