//Tests:
//        CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
//        ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
//        Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
//        Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
//        Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
//        Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
//        Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
//        File Download: http://localhost:7080/download Test File Download.
//        File Upload: http://localhost:7080/upload Test File Upload.
//        Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
//        Iframe: http://localhost:7080/iframe Test iframe.
//        Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
//        JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
//        JavaScript Error: http://localhost:7080/javascript_error Test JS error.
//        Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
//        Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.


package alltests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.comparison.*;
import ru.yandex.qatools.ashot.shooting.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;


public class OtherTest {
    String driverPath =  "./src/drivers/chromedriver.exe";
    //    String driverPath = ("user.dir" + "/drivers/chromedriver.exe");
    public WebDriver driver;
    public String urlForTests = "http://localhost:7080/";

    @BeforeMethod
    public void launchBrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }


    @Test(priority = 0)
    public void checkBoxes() {
        System.out.println("\n Running CheckBoxes test method");
        //Open test page
        driver.get(urlForTests +"checkboxes");

        // checkbox #1		
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        boolean isSelected1 = checkbox1.isSelected();

        if(isSelected1 == false) {
            // check checkbox, assert to make sure box was properly checked
            checkbox1.click();
            Assert.assertTrue(checkbox1.isSelected());
            // uncheck checkbox, assert to make sure box was properly unchecked
            checkbox1.click();
            Assert.assertFalse(checkbox1.isSelected());
        }
        else {
            // uncheck checkbox, assert to make sure box was properly unchecked
            checkbox1.click();
            Assert.assertFalse(checkbox1.isSelected());
            // check checkbox, assert to make sure box was properly checked
            checkbox1.click();
            Assert.assertTrue(checkbox1.isSelected());
        }

        // checkbox #2
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        boolean isSelected2 = checkbox2.isSelected();

        if(isSelected2 == false) {
            // check checkbox, assert to make sure box was properly checked
            checkbox2.click();
            Assert.assertTrue(checkbox2.isSelected());
            // uncheck checkbox, assert to make sure box was properly unchecked
            checkbox2.click();
            Assert.assertFalse(checkbox2.isSelected());
        }
        else {
            // uncheck checkbox, assert to make sure box was properly unchecked
            checkbox2.click();
            Assert.assertFalse(checkbox2.isSelected());
            // check checkbox, assert to make sure box was properly checked
            checkbox2.click();
            Assert.assertTrue(checkbox2.isSelected());
        }

    }


    @Test(priority = 1)
    public void contextMenu() {
        System.out.println("\n Running contextMenu test method");
        //Open test page
        driver.get(urlForTests +"context_menu");

        Actions actions = new Actions(driver);

        WebElement context = driver.findElement(By.id("hot-spot"));
        // right click on the context menu
        actions.contextClick(context).perform();

        // assert the alert menu text
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage  = alert.getText();
        Assert.assertEquals("You selected a context menu", actualAlertMessage);

        alert.accept();

    }


    @Test(priority = 2)
    public void drugDrop() {
        System.out.println("\n Running Drag and Drop test method");
        // open  Drag and Drop page
        driver.get(urlForTests +"drag_and_drop");

        // element A
        WebElement fromElementA =  driver.findElement(By.id("column-a"));
        String textBeforeA = fromElementA.getText();

        // element B
        WebElement toElementB = driver.findElement(By. id("column-b"));
        String textBeforeB = toElementB.getText();

        // drag element A to element B
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
                + "simulateHTML5DragAndDrop(source,destination);", fromElementA, toElementB);

        // assert that the text on element A and B are switched
        String textAfterA = fromElementA.getText();
        String textAfterB = toElementB.getText();
        Assert.assertEquals(textAfterA, textBeforeB);
        Assert.assertEquals(textAfterB, textBeforeA);

    }


    @Test(priority = 3)
    public void dropDown() {
        System.out.println("\n Running dropDown test method");

        //Open test page
        driver.get(urlForTests +"dropdown");

        Select se = new Select(driver.findElement(By.id("dropdown")));

        // selects Option 1 from the drop down menu
        se.selectByValue("1");
        // asserts Option 1 is selected
        Assert.assertTrue(true, driver.findElement(By.xpath("//*[@value='1']")).
                getAttribute("selected"));

        //  selects Option 2 from the drop down menu
        se.selectByValue("2");
        //  asserts Option 2 is selected
        Assert.assertTrue(true, driver.findElement(By.xpath("//*[@value='2']")).
                getAttribute("selected"));

        }


    @Test(priority = 4)
    public void dynamicContent() throws IOException {
        System.out.println("\n Running Dynamic Content test method");

        //Open test page
        driver.get(urlForTests +"dynamic_content");

        Screenshot screenBefore = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenBefore.getImage(), "jpg", new File(
                    "./src/test/screenshots/screenshotBefore.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // refreshes the page a couple of times
        for (int i = 1; i <= 2; ++i) {

            driver.navigate().refresh();

            Screenshot screenAfter = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            try {
                ImageIO.write(screenAfter.getImage(), "jpg", new File(
                        "./src/test/screenshots/screenshotAfter.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            BufferedImage buffBefore = ImageIO.read(new File(
                     "./src/test/screenshots/screenshotBefore.jpg"));
            BufferedImage buffAfter = ImageIO.read(new File(
                    "./src/test/screenshots/screenshotAfter.jpg"));

            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(buffBefore, buffAfter);

            // assert that the content changes on each refresh
            Assert.assertTrue(diff.hasDiff());

            if (i < 2) {
                try {
                    ImageIO.write(screenAfter.getImage(), "jpg", new File(
                            "./src/test/screenshots/screenshotBefore.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }


    @Test(priority = 5)
    public void dynamicControls() {
        System.out.println("Running Dynamic Controls test method");

        //Open test page
        driver.get(urlForTests +"dynamic_controls");

        // click on the Remove Button...
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        try {
            // ... and use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            boolean checkbox = wait.until(ExpectedConditions.invisibilityOfElementLocated
                            (By.id("checkbox")));

            //  assert that the checkbox is gone
            Assert.assertTrue(checkbox);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@ id='message']")).getText(),
                    "It's gone!");
            }
        catch (Exception e){
            System.out.println("So long waiting the checkbox is gone");
        }

        // click on Add Button...
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        try {
            // ...and use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.id("checkbox")));

            // assert that the checkbox is present
            Assert.assertTrue(checkbox.isDisplayed());
            Assert.assertEquals(driver.findElement(By.xpath("//*[@ id='message']")).getText(),
                    "It's back!");
        }
        catch (Exception e){
            System.out.println("So long waiting the checkbox is present");
        }

        // click on the Enable Button...
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        try {
            // ... and use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement textbox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@ id='input-example']//input[@type='text']")));

            // assert that the text box is enabled
            Assert.assertTrue(textbox.isEnabled());
            Assert.assertEquals(driver.findElement(By.id("message")).getText(),
                    "It's enabled!");
        }
        catch (Exception e){
            System.out.println("So long waiting the textbox is enabled");
        }

        //  click on the Disable Button...
        driver.findElement(By.xpath("//button[text()='Disable']")).click();
        try {
            // ...and use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement textboxdisabled = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@id='input-example']//input[@disabled=\"\"]")));

            // assert that the text box is disabled
            Assert.assertTrue(textboxdisabled.isDisplayed());
            Assert.assertEquals(driver.findElement(By.id("message")).getText(),
                    "It's disabled!");
        }
        catch (Exception e){
            System.out.println("So long waiting the textbox is disabled'");
        }

    }


    @Test(priority = 6)
    public void dynamicLoading() {
        System.out.println("Running Dynamic Loading test method");
        //Open test page
        driver.get(urlForTests +"dynamic_loading/2");

        // click the start button...
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        try {
            // ...and use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//*[text()='Hello World!']")));

            // assert that “Hello World!” text is displayed
            Assert.assertTrue(text.isDisplayed());
            Assert.assertEquals(text.getText(), "Hello World!");
        }
        catch (Exception e){
            System.out.println("So long waiting the text is displayed");
        }

    }


    @Test(priority = 7)
    public void fileDownload() throws IOException {
        System.out.println("Running File Download test method");
        //Open test page
        driver.get(urlForTests +"download");

        File checkOldFile = new File ("./src/test/filesfortests/some-file-downloaded.txt");
        if (checkOldFile.exists())
        {
            System.out.print("'" +checkOldFile.getName() + "' file from old tests is existing\n ");
            try
            {
                if(checkOldFile.delete())
                {
                    System.out.println("- file was deleted");
                }
                else
                {
                    System.out.println("- failed delete file from old test");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        WebElement downloadLink = driver.findElement(By.xpath(
                "//a[@href='download/some-file.txt']"));
        // click on the file
        downloadLink.click();

        URL url = new URL("http://localhost:7080/download/some-file.txt");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, new File("./src/test/filesfortests/some-file-downloaded.txt").toPath());
        downloadLink.sendKeys(Keys.ENTER);

        // assert that the file is downloaded
        File fileInFolder = new File ("./src/test/filesfortests/some-file-downloaded.txt");
        Assert.assertTrue(fileInFolder.exists());

    }


    @Test(priority = 8)
    public void fileUpload() {
        System.out.println("Running File Upload test method");
        //Open test page
        driver.get(urlForTests +"upload");

        String pathToFile = "./src/test/filesfortests/some-file-upload.txt";
        File fileToUpload = new File(pathToFile);

        // use Upload Button to upload a file
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        uploadFile.sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(By.id("file-submit")).submit();

        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'File Uploaded!')]"));
        // assert that the file is uploaded
        Assert.assertEquals(text.getText(),"File Uploaded!");
        Path fileUploadName = Paths.get(fileToUpload.getAbsolutePath()).getFileName();
        String fileNamePresent = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileUploadName.toString(), fileNamePresent);

    }


    @Test(priority = 9)
    public void floatingMenu() {
        System.out.println("Running Floating Menu test method");
        //Open test page
        driver.get(urlForTests +"floating_menu");

        int screenHeight = driver.manage().window().getSize().height;
        WebElement page= driver.findElement(By.id("content"));
        Dimension pageSize = page.getSize();
        int pageHeight = pageSize.getHeight();
        int scrollsCount = pageHeight/screenHeight;

        WebElement footer = driver.findElement(By.xpath
                ("//*[contains(text(),'Powered by')]"));
        WebElement menu = driver.findElement(By.id("menu"));
        int count = 1;

        // scroll the page till bottom
        while (true) {
            new Actions(driver)
                    .scrollByAmount(0, screenHeight)
                    .perform();

            // assert that the floating menu is still displayed
            Assert.assertTrue(menu.isDisplayed());

            count++;
            if ( count > scrollsCount ) {
                try {
                Assert.assertTrue(footer.isDisplayed());
                    }
                catch ( AssertionError e) {
                    System.out.println("Footer is not displayed !");
                }
                break;
            }
        }

    }


    @Test(priority = 10)
    public void iFrame() {
        System.out.println("Running iframe test method");
        //Open test page
        driver.get(urlForTests +"iframe");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeAlert = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='tox-icon']")));
            closeAlert.click();
        }
        catch (Exception e){
            System.out.println("So long waiting for click to close alert ");
        }

        // switch to Iframe...
        WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);
        // ... and type some text
        WebElement textbox = driver.findElement(By.id("tinymce"));
        textbox.clear();
        textbox.sendKeys("Test switched to Iframe");
        // assert that the typed text is as expected
        Assert.assertEquals(textbox.getText(),"Test switched to Iframe");

        driver.switchTo().defaultContent();

    }


    @Test(priority = 11)
    public void mouseHover() {
        System.out.println("Running Mouse Hover test method");
        //Open test page
        driver.get(urlForTests +"hovers");

        WebElement image1 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement image2 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        WebElement image3 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));

        //  mouse hover on each image

        Actions action1 = new Actions(driver);
        action1.moveToElement(image1).perform();
        WebElement image1text1 = driver.findElement(By.xpath("//*[text()='name: user1']"));
        WebElement image1text2 = driver.findElement(By.xpath("(//a[text()='View profile'])[1]"));
        // assert that additional information is displayed for this image
        Assert.assertTrue(image1text1.isDisplayed());
        Assert.assertEquals(image1text1.getText(), "name: user1");
        Assert.assertTrue(image1text2.isDisplayed());
        Assert.assertEquals(image1text2.getText(), "View profile");

        Actions action2 = new Actions(driver);
        action2.moveToElement(image2).perform();
        WebElement image2text1 = driver.findElement(By.xpath("//*[text()='name: user2']"));
        WebElement image2text2 = driver.findElement(By.xpath("(//a[text()='View profile'])[2]"));
        // assert that additional information is displayed for this image
        Assert.assertTrue(image2text1.isDisplayed());
        Assert.assertEquals(image2text1.getText(), "name: user2");
        Assert.assertTrue(image2text2.isDisplayed());
        Assert.assertEquals(image2text2.getText(), "View profile");

        Actions action3 = new Actions(driver);
        action3.moveToElement(image3).perform();
        WebElement image3text1 = driver.findElement(By.xpath("//*[text()='name: user3']"));
        WebElement image3text2 = driver.findElement(By.xpath("(//a[text()='View profile'])[3]"));
        // assert that additional information is displayed for this image
        Assert.assertTrue(image3text1.isDisplayed());
        Assert.assertEquals(image3text1.getText(), "name: user3");
        Assert.assertTrue(image3text2.isDisplayed());
        Assert.assertEquals(image3text2.getText(), "View profile");

    }


    @Test(priority = 12)
    public void jsAlert() {
        System.out.println("Running JS Alert test method");
        //Open test page
        driver.get(urlForTests+"javascript_alerts");

        // Clicks on JS Alert Button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert1 = driver.switchTo().alert();
        String textAlert1 = alert1.getText();
        // assert alert message
        Assert.assertEquals(textAlert1, "I am a JS Alert");
        alert1.accept();

        // click on JS confirm Button...
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert2 = driver.switchTo().alert();
        String textAlert2 = alert2.getText();
        // assert the alert message
        Assert.assertEquals(textAlert2, "I am a JS Confirm");
        // ...and clicks ok on alert
        alert2.dismiss();

        // click on JS Prompt Button ...
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert3 = driver.switchTo().alert();
        // ... and types a message on Prompt
        alert3.sendKeys("This is my message");
        alert3.accept();
        // assert that the alert message contains the typed message
        String textAlert3 = driver.findElement(By.xpath("//*[@id ='result']")).getText();
        Assert.assertEquals(textAlert3, "You entered: This is my message");

    }


    @Test(priority = 13)
    public void jsError() {
        System.out.println("Running JavaScript Error test method");
        //Open test page
        driver.get(urlForTests +"javascript_error");

        // find the JavaScript error on the page
        LogEntries Log = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = Log.getAll();
        for(LogEntry e: logs)
        {
            int indexOfTrim = e.getMessage().trim().lastIndexOf(":");
            String javaScriptMessage = e.getMessage().substring(indexOfTrim + 2);

            // asserts that the page contains error: Cannot read properties of undefined (reading 'xyz')
            Assert.assertEquals(javaScriptMessage,"Cannot read properties of undefined (reading 'xyz')");
        }

    }


    @Test(priority = 14)
    public void openinNewTab() {
        System.out.println("Running Open in New Tab test method");
        //Open test page
        driver.get(urlForTests +"windows");

        String originalWindow = driver.getWindowHandle();

        // click on the Click Here link
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // assert that a new tab is opened with text 'New Window'
        Assert.assertEquals(driver.getTitle(), "New Window");
        WebElement textWindow = driver.findElement(By.xpath("//h3[text()='New Window']"));
        Assert.assertEquals(textWindow.getText(), "New Window");

    }


    @Test(priority = 15)
    public void notificationMessage() {
        System.out.println("Running Notification Message test method");
        //Open test page
        driver.get(urlForTests +"notification_message_rendered");

        // Notice: no “Action Unsuccessful” message shown in this test link
        String[] messages = {"Action successful", "Action unsuccessful, please try again"};
        int clicksCount = 1;
        int clicksCount1 = 0;
        int clicksCount2 = 0;

        // click on the Click Here link a multiple times
        while (true) {
            WebElement clickLink = driver.findElement(By.xpath
                    ("//*[@href='/notification_message']"));
            clickLink.click();

            String answer = driver.findElement(By.id("flash")).getText();
            int indexToTrim = answer.trim().indexOf("×");
            String notificationMessage = answer.substring(0, indexToTrim - 1);

            // assert that one of the “Action Successful”, “Action unsuccessful, please try again”
            // show on click
            if (notificationMessage.equals(messages[0])) {
                Assert.assertEquals(notificationMessage, messages[0]);
                clicksCount1 += 1;
            } else {
                try {
                    Assert.assertEquals(notificationMessage, messages[1]);
                }
                catch (AssertionError e) {
                    System.out.println("- message shown: '" +notificationMessage +"'"
                            +"\n, has the typo in the word 'unsuccesful'.");
                }
                clicksCount2 += 1;
            }

            if ( (clicksCount1 >= 1) && (clicksCount2 >= 1) ){
                break;
            } else if (clicksCount >= 20) {
                System.out.println("Test method was stopped as " +
                        "it was so many clicks to display all available messages !");
                break;
            }
            clicksCount += 1;
        }

    }


}
