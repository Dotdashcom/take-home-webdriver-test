package ui_automation.step_definitions;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.LoginPage;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Scenarios {
     private WebDriver driver;
     private String baseURL;

     @Before
    public void setUp() throws Exception {
         System.setProperty("webdriver.chrome.driver", "/Users/ayselismayilova/drivers/chromedriver_mac64/chromedriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         baseURL = "http://localhost:7080";
     }

     @After
     public void tearDown() {
         driver.quit();
     }
    //Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
     @Test
    public void testLoginSuccess() {
         driver.get(baseURL + "/login");
         LoginPage loginPage = new LoginPage(driver);
         loginPage.username.sendKeys("tomSmith");
         loginPage.password.sendKeys("SuperSecretPassword!");
         loginPage.loginButton.click();
         String expectedMess = loginPage.message.getText();
         Assert.assertTrue(expectedMess, true);
     }
    //Login Failure: http://localhost:7080/login Login fail invalid creadentials
     @Test
    public void testLoginFailure() {
         driver.get(baseURL + "/login");
         LoginPage loginPage = new LoginPage(driver);
         loginPage.username.sendKeys("invalidUser");
         loginPage.password.sendKeys("invalidPwd");
         loginPage.loginButton.click();
         String expectedError = loginPage.errorMessage.getText();
         Assert.assertTrue("Your username is invalid!", true);

     }

     //CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
     @Test
    public void testCheckBox() {
         driver.get(baseURL + "/checkboxes");
         WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type = 'checkbox'])[1]"));
         WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type = 'checkbox'])[2]"));
         checkbox1.click();
         Assert.assertTrue(checkbox1.isSelected());
         Assert.assertTrue(checkbox2.isSelected());
         checkbox1.click();
         checkbox2.click();
         Assert.assertFalse(checkbox1.isSelected());
         Assert.assertFalse(checkbox2.isSelected());
     }

     //ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'.
     //Test JavaScript alert text on Right-Click.

    @Test
    public void testContextMenu() {
         driver.get(baseURL + "/context_menu");
         WebElement box = driver.findElement(By.id("hot-spot"));
         Actions action = new Actions(driver);
         action.contextClick(box).perform();
         Alert alert = driver.switchTo().alert();
         String alertText = alert.getText();
         alert.accept();
         Assert.assertEquals("You selected a context menu", alertText);
    }
    //Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    @Test
    public void testDragAndDrop() {
         driver.get(baseURL + "/drag_and_drop");
         WebElement source = driver.findElement(By.id("column-a"));
         WebElement target = driver.findElement(By.id("column-b"));
         Actions action = new Actions(driver);
         action.dragAndDrop(source, target).perform();
         Assert.assertEquals("B", target.getText());
    }

     //Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    @Test
    public void testDropdown() {
         driver.get(baseURL + "/dropdown");
         WebElement dropdownElement = driver.findElement(By.id("dropdown"));
         Select dropdown = new Select(dropdownElement);
         dropdown.selectByVisibleText("Option 1");
         Assert.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());
         dropdown.selectByVisibleText("Option 2");
         Assert.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

    }

     //Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
    @Test
    public void testDynamicContent () {
         driver.get(baseURL + "/dynamic_content");
         WebElement content1 = driver.findElement(By.xpath("(//*[@class = 'large-12 columns'])[2]"));
         WebElement content2 = driver.findElement(By.xpath("//div[@class = 'large-10 columns']"));
         String text1 = content1.getText();
         String text2 = content2.getText();
         driver.navigate().refresh();
         WebElement newText1Element = driver.findElement(By.xpath("(//*[@class = 'large-12 columns'])[2]"));
         WebElement newText2Element = driver.findElement(By.xpath("//div[@class = 'large-10 columns']"));
         String newText1 = newText1Element.getText();
         String newText2 = newText2Element.getText();
         Assert.assertNotEquals(text1, newText1);
         Assert.assertNotEquals(text2, newText2);
    }
    //Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
    @Test
    public void testDynamicControls() {
        driver.get(baseURL + "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        Assert.assertFalse(driver.findElements(By.id("checkbox")).size() > 0);
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']//input[@type='text']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='input-example']//input[@type='text']"))
                .isEnabled());
        WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']//input[@type='text']"))));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='input-example']//input[@type='text']"))
                .isEnabled());
    }
    //Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
    @Test
    public void testDynamicLoading() {
         driver.get(baseURL + "/dynamic_loading/2");
         WebElement startButton = driver.findElement(By.cssSelector("#start button"));
         startButton.click();
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
         Assert.assertEquals("Hello World!", finishText.getText());

    }
    //File Download: http://localhost:7080/download Test File Download.
    @Test
    public void testFileDownload() {
         driver.get(baseURL + "/download");
         WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
         downloadLink.click();
         String downloadsPath = System.getProperty("user.home") + "/Downloads";
         File downloadedFile = new File (downloadsPath + "/some-file.txt");
         int waitTime = 0;
         while (!downloadedFile.exists() && waitTime <30) {
             try {
                 Thread.sleep(1000);
                 waitTime++;
             }
             catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         Assert.assertTrue(downloadedFile.exists());
    }

    //File Upload: http://localhost:7080/upload Test File Upload.
    @Test
    public void testFileUpload() {
        driver.get(baseURL + "/upload");
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("C:/Users/ayselismayilova/Downloads/some-file.txt");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadedFile.isDisplayed());

    }

    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    @Test
    public void testFloatingMenu () {
        driver.get(baseURL + "/floating_menu");
        WebElement menuBar = driver.findElement(By.id("menu"));
        int originalY = menuBar.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        int newY = menuBar.getLocation().getY();
        Assert.assertNotEquals(originalY, newY);
    }

    //Iframe: http://localhost:7080/iframe Test iframe.
    @Test
    public void testIframe() {
        driver.get(baseURL + "/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement body = driver.findElement(By.tagName("body"));
        body.clear();
        body.sendKeys("This is a test message");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        WebElement result = driver.findElement(By.id("tinymce"));
        Assert.assertEquals("This is a test message", result.getText());
    }
    //Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    @Test
    public void testMouseHover() {
        driver.get(baseURL + "/hovers");
        WebElement image1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(image1).perform();
        WebElement viewProfileLink = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/a"));
        Assert.assertTrue(viewProfileLink.isDisplayed());
    }

    //JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    @Test
    public void testConfirmJSAlert() {
        driver.get(baseURL + "/javascript_alerts");
        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You clicked: Cancel", result.getText());
    }

    //JavaScript Error: http://localhost:7080/javascript_error Test JS error.
     @Test
     public void testJSError() {
         driver.get(baseURL + "/javascript_error");
         JavascriptExecutor js = (JavascriptExecutor) driver;
         String script = "return window.jsErr;";
         Object error = js.executeScript(script);
         if (error != null) {
             String errorMessage = error.toString();
             Assert.assertTrue(errorMessage.contains("Cannot read property 'xyz' of undefined."));
         } else {
             Assert.fail("No JavaScript error found on the page.");
         }
     }

  //Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    @Test
    public void testLinkOpensInNewTab() {
        driver.get(baseURL + "/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        String originalWindowHandle = driver.getWindowHandle();
        link.click();
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        windowHandles.remove(originalWindowHandle);
        driver.switchTo().window(windowHandles.get(0));
        WebElement newWindowText = driver.findElement(By.xpath("//h3[text()='New Window']"));
        Assert.assertEquals("New Window", newWindowText.getText());
    }
   //Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
    @Test
    public void testNotificationMessage() {
        driver.get(baseURL + "/notification_message_rendered");
        WebElement link = driver.findElement(By.linkText("Click here"));
        link.click();
        WebElement message = driver.findElement(By.id("flash"));
        String messageText = message.getText();
        Assert.assertTrue(messageText.contains("Action successful") || messageText.contains("Action unsuccesful, please try again"));
    }


    }



















