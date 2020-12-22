package tests;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;

import java.io.File;
import java.util.*;

import static org.testng.Assert.*;

public class Tests extends TestBase{

    @Test(priority = 1, description = "Login Success")
    public void loginSuccessTest(){
        driver.get(baseUrl+"/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials(ConfigurationReader.getProperty("username"),
                                   ConfigurationReader.getProperty("password"));
        assertTrue(loginPage.getMessage().contains("You logged into a secure area!"),"Login Success message is not displayed");

    }

    @Test(priority = 2, description = "Login Failure")
    public void loginFailureTest(){
        driver.get(baseUrl+"/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials(ConfigurationReader.getProperty("username"), "wrongpassword");
        assertTrue(loginPage.getMessage().contains("Your password is invalid!"),"Invalid password message is not displayed");

        loginPage.enterCredentials("wrongusername", ConfigurationReader.getProperty("password"));
        assertTrue(loginPage.getMessage().contains("Your username is invalid!"), "Invalid username message is not displayed");

    }

    @Test(priority = 3, description = "Checkboxes")
    public void checkboxesTest(){
        driver.get(baseUrl+"/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //assert 2 checkboxes are displayed on page
        assertEquals(checkBoxes.size(),2 );
        //assert default checkbox states.
        assertFalse(checkBoxes.get(0).isSelected());
        assertTrue(checkBoxes.get(1).isSelected());

        //click first one and assert checkbox was successfully checked
        checkBoxes.get(0).click();
        assertTrue(checkBoxes.get(0).isSelected());

        //click second one and assert checkbox was successfully unchecked
        checkBoxes.get(1).click();
        assertFalse(checkBoxes.get(1).isSelected());

    }

    @Test(priority = 4, description = "ContextMenu")
    public void contextMenuTest(){
        driver.get(baseUrl+"/context_menu");
        WebElement area = driver.findElement(By.id("hot-spot"));
        //right click
        new Actions(driver).contextClick(area).build().perform();
        //assert message of js alert
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText().trim(),"You selected a context menu");
    }

    @Test(priority = 5, description = "Drag and Drop")
    public void dragAndDropTest() throws InterruptedException{
        driver.get(baseUrl+"/drag_and_drop");
       WebElement box1 = driver.findElement(By.id("column-a"));
       WebElement box2 = driver.findElement(By.id("column-b"));
       //use javascript to drag and drop. Normal way using Actions class did not work
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", box1, box2);
        Thread.sleep(2000);
        box1 = driver.findElement(By.id("column-a"));
        box2 = driver.findElement(By.id("column-b"));
        assertEquals(box1.getText(), "B");
        assertEquals(box2.getText(), "A");
    }

    @Test(priority = 6, description = "Dropdown")
    public void dropdownTest(){
        driver.get(baseUrl+"/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByVisibleText("Option 1");
        assertEquals(dropDown.getFirstSelectedOption().getText(),"Option 1");
        dropDown.selectByVisibleText("Option 2");
        assertEquals(dropDown.getFirstSelectedOption().getText(),"Option 2");
    }

    @Test(priority = 7, description = "Dynamic Content")
    public void dynamicContentTest(){
        driver.get(baseUrl+"/dynamic_content");
        List<Map<String, String>> rowsData = new ArrayList<>();
        //insert all data into list of maps
        for (int i = 0; i <= 2; i++) {
            Map<String, String> rowMap = new HashMap<>();
            List<WebElement> images = driver.findElements(By.xpath("//div[@id='content']//img"));
            List<WebElement> texts = driver.findElements(By.xpath("//div[@id='content']//div[@class='row']"));

            for (int j = 0; j <= 2 ; j++) {
                rowMap.put(images.get(j).getAttribute("src").trim(), texts.get(j).getText().trim());
            }

            rowsData.add(rowMap);

            driver.navigate().refresh();
        }

        //assert each map data is different
        assertNotEquals(rowsData.get(0),rowsData.get(1));
        assertNotEquals(rowsData.get(0),rowsData.get(2));
        assertNotEquals(rowsData.get(1),rowsData.get(2));
    }

    @Test(priority = 8, description = "Dynamic Controls")
    public void dynamicControlsTest(){
        driver.get(baseUrl+"/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,20);

        for (int i = 1; i <= 2; i++) {

            if (i == 1) {
                WebElement remove = driver.findElement(By.xpath("//button[.='Remove']"));
                remove.click();
                WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
                wait.until(ExpectedConditions.invisibilityOf(checkbox));
                assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),0);
            }else{
                WebElement add = driver.findElement(By.xpath("//button[.='Add']"));
                add.click();
                WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
                wait.until(ExpectedConditions.visibilityOf(checkbox));
                assertTrue(checkbox.isDisplayed());
            }
        }

        for (int i = 1; i <= 2; i++) {

            WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));

            if (i == 1) {
                WebElement enable = driver.findElement(By.xpath("//button[.='Enable']"));
                enable.click();
                wait.until((ExpectedCondition<Boolean>) driver -> textBox.isEnabled());
                assertTrue(textBox.isEnabled());
            }else{
                WebElement disable = driver.findElement(By.xpath("//button[.='Disable']"));
                disable.click();
                wait.until((ExpectedCondition<Boolean>) driver -> !textBox.isEnabled());
                assertFalse(textBox.isEnabled());
            }
        }

    }

    @Test(priority = 9, description = "Dynamic Loading")
    public void dynamicLoadingTest(){
        driver.get(baseUrl+"/dynamic_loading/2");
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement start = driver.findElement(By.xpath("//button[.='Start']"));
        start.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        String text = driver.findElement(By.id("finish")).getText();
        assertEquals(text,"Hello World!");
    }

    @Test(priority = 10, description = "File Download")
    public void fileDownloadTest() throws InterruptedException {
        driver.get(baseUrl+"/download");
        driver.findElement(By.linkText("some-file.txt")).click();
        Thread.sleep(2000);
        assertTrue(new File(System.getProperty("user.home")+"/Downloads/some-file.txt").exists());
    }

    @Test(priority = 11, description = "File Upload")
    public void fileUploadTest() {
        driver.get(baseUrl+"/upload");
        WebElement fileUpload = driver.findElement(By.name("file"));
        fileUpload.sendKeys(System.getProperty("user.dir") + "/some-file.txt");
        driver.findElement(By.xpath("//input[@value='Upload']")).click();
        String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText().trim();
        assertEquals(uploadedFileName,"some-file.txt");
    }

    @Test(priority = 12, description = "Floating menu")
    public void floatingMenuTest()  {
        driver.get(baseUrl+"/floating_menu");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());
    }

    @Test(priority = 13, description = "Iframe")
    public void iFrameTest()  {
        driver.get(baseUrl+"/iframe");
        try{
            WebElement closeIcon = driver.findElement(By.xpath("//div[@aria-label='Close']"));
            if (closeIcon.isDisplayed())
                closeIcon.click();
        }catch (Exception e){}
        WebElement contentArea = driver.switchTo().frame("mce_0_ifr").findElement(By.xpath("//body[@id='tinymce']"));
        contentArea.clear();
        contentArea.sendKeys("DotDash is the best!");
        assertEquals(contentArea.getText(),"DotDash is the best!" );
        driver.switchTo().defaultContent();
    }

    @Test(priority = 14, description = "Mouse Hover")
    public void mouseHoverTest() throws InterruptedException {
        driver.get(baseUrl+"/hovers");
       List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']/img"));

        Actions actions = new Actions(driver);
        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).build().perform();
            Thread.sleep(1000);
            assertTrue(driver.findElement(By.xpath("//div[@class='figcaption']/h5[.='name: user"+(i+1)+"']")).isDisplayed());
        }
    }

    @Test(priority = 15, description = "JavaScript Alerts")
    public void javaScriptAlertsTest()  {
        driver.get(baseUrl+"/javascript_alerts");
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        jsAlertBtn.click();
        Alert jsAlert = driver.switchTo().alert();
        assertEquals(jsAlert.getText(),"I am a JS Alert");
        jsAlert.accept();

        jsConfirmBtn.click();
        Alert jsConfirm = driver.switchTo().alert();
        assertEquals(jsConfirm.getText(),"I am a JS Confirm");
        jsConfirm.accept();

        jsPromptBtn.click();
        Alert jsPrompt = driver.switchTo().alert();
        jsPrompt.sendKeys("DotDash is the best!");
        jsPrompt.accept();

        String text = driver.findElement(By.id("result")).getText();
        assertEquals(text, "You entered: DotDash is the best!");

    }

    @Test(priority = 16, description = "JavaScript Error")
    public void javaScriptErrorTest() {
        driver.get(baseUrl+"/javascript_error");
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        assertTrue(entries.getAll().get(0).getMessage().contains("Cannot read property 'xyz' of undefined"));
    }

    @Test(priority = 17, description = "Open in New Tab")
    public void openInNewTabTest()  {
        driver.get(baseUrl+"/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowIDs = driver.getWindowHandles();
        int counter = 1;
        for (String window : windowIDs) {
            driver.switchTo().window(window);
            if(counter == 1){
                assertEquals(driver.getTitle(),"The Internet");
            }else if (counter == 2){
                assertEquals(driver.getTitle(),"New Window");
                assertTrue(driver.findElement(By.xpath("//h3[.='New Window']")).isDisplayed());
            }
            counter++;
        }
    }

    @Test(priority = 18, description = "Notification Message")
    public void notificationMessageTest()  {
        driver.get(baseUrl+"/notification_message_rendered");
        
        List<String> possibleMessages = new ArrayList<>();
        possibleMessages.add("Action unsuccesful, please try again");
        possibleMessages.add("Action successful");

        for (int i = 0; i < 10; i++) {
            WebElement clickHere = driver.findElement(By.linkText("Click here"));
            clickHere.click();
            String message = driver.findElement(By.xpath("//div[@class='flash notice']")).getText().trim();
            message = message.replace("×","").trim();
            assertTrue(possibleMessages.contains(message));
        }
    }
}
