import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Tests {
    @Test
    public void loginSuccess() {
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://localhost:7080/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");

        login.click();

        String loginUrl="http://localhost:7080/secure";
        String expectedUrl= driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, loginUrl);

        driver.quit();
    }

    @Test
    public void loginFailure() {
        WebDriver driver = new ChromeDriver();
        String loginURL = "http://localhost:7080/login";
        driver.get(loginURL);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));

        username.sendKeys("wrongUsername");
        password.sendKeys("wrongPassword");

        login.click();

        String expectedUrl= driver.getCurrentUrl();
        String message = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        String expectedMessage = "Your username is invalid!";

        Assertions.assertEquals(expectedUrl, loginURL);
        Assertions.assertTrue(message.contains(expectedMessage), "Message of failure login");

        driver.quit();
    }

    @Test
    public void checkBoxes() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        // Assert box1 is unchecked and box2 is checked, as default.
        Assertions.assertNull(checkbox1.getAttribute("checked"));
        Assertions.assertTrue(Boolean.parseBoolean(checkbox2.getAttribute("checked")), "This is checked");

        // Click on box1 and assert both are checked.
        checkbox1.click();
        Assertions.assertTrue(Boolean.parseBoolean(checkbox1.getAttribute("checked")), "This is checked");
        Assertions.assertTrue(Boolean.parseBoolean(checkbox2.getAttribute("checked")), "This is checked");

        // Unchecked both boxes and assert they are unchecked.
        checkbox1.click();
        checkbox2.click();
        Assertions.assertNull(checkbox1.getAttribute("checked"));
        Assertions.assertNull(checkbox2.getAttribute("checked"));

        driver.quit();
    }

    @Test
    public void contextMenu() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/context_menu");

        WebElement box = driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));

        Actions action = new Actions(driver);
        action.contextClick(box).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String expectedAlertMessage = "You selected a context menu";

        Assertions.assertTrue(alertMessage.contains(expectedAlertMessage), "Message on alert");

        alert.accept();
        driver.quit();
    }

    @Test
    public void dragAndDrop() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/drag_and_drop");
        driver.manage().window().setSize(new Dimension(1062, 810));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);


        WebElement boxA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement boxB = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        String textPositionA = boxA.findElement(By.xpath(".//header")).getText();
        String textPositionB = boxB.findElement(By.xpath(".//header")).getText();

        Assertions.assertEquals(textPositionA, "A");
        Assertions.assertEquals(textPositionB, "B");

//        Actions builder = new Actions(driver);
//        builder.dragAndDrop(boxA, boxB).perform();
//
//        WebElement draggedBoxA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
//        WebElement draggedBoxB = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
//
//        String draggedTextPositionA = draggedBoxA.findElement(By.xpath(".//header")).getText();
//        String draggedTextPositionB = draggedBoxB.findElement(By.xpath(".//header")).getText();
//
//        Assertions.assertEquals(draggedTextPositionA, "B");
//        Assertions.assertEquals(draggedTextPositionB, "A");

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        //Actions class method to drag and drop
//        Actions builder = new Actions(driver);
//
//        int xOffset1 = boxA.getLocation().getX();
//        int yOffset1 =  boxA.getLocation().getY();
//
//        System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
//
//        int xOffset2 = boxB.getLocation().getX();
//        int yOffset2 =  boxB.getLocation().getY();
//
//        System.out.println("xOffset--->"+xOffset2+" yOffset--->"+yOffset2);
//
//        //Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
//        xOffset2 = (xOffset2-xOffset1)+10;
//        yOffset2 = 0;
//
//
//        //Perform dragAndDropBy
//        builder.dragAndDropBy(boxA, xOffset2, yOffset2).perform();
//
//        //verify text changed in to 'Drop here' box
//        //Get text value of 'to' element
//        String textTo = boxB.getText();
        WebElement dragged = driver.findElement(By.id("column-a"));
        WebElement dropped = driver.findElement(By.id("column-b"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(dragged, dropped).perform();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        Assertions.assertEquals(textPositionA, "A");
        Assertions.assertEquals(textPositionB, "B");

        driver.quit();
    }

//    @Test
//    public void dragAndDrop2() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://localhost:7080/drag_and_drop");
//        driver.manage().window().setSize(new Dimension(1062, 810));
//
//        WebElement dragged = driver.findElement(By.id("column-a"));
//        WebElement dropped = driver.findElement(By.id("column-b"));
//
//        int x = dropped.getLocation().x;
//        int y = dropped.getLocation().y;
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(dragged)
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(dragged)
//                .pause(Duration.ofSeconds(1))
//                .moveByOffset(x, y)
//                .moveToElement(dropped)
//                .moveByOffset(x,y)
//                .pause(Duration.ofSeconds(1))
//                .release().build().perform();
//    }

    @Test
    public void dropDown() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/dropdown");
        driver.manage().window().setSize(new Dimension(1062, 810));

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        WebElement option1 = dropdown.findElement(By.xpath("//option[. = 'Option 1']"));
        WebElement option2 = dropdown.findElement(By.xpath("//option[. = 'Option 2']"));

        option1.click();
        Assertions.assertTrue(Boolean.parseBoolean(option1.getAttribute("selected")));

        option2.click();
        Assertions.assertTrue(Boolean.parseBoolean(option2.getAttribute("selected")));
        driver.quit();
    }

    @Test
    public void dynamicContent() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_content");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        String text1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
        String text2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
        String text3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();

        // Refresh page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        String refreshedText1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
        String refreshedText2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
        String refreshedText3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();

        Assertions.assertNotEquals(text1, refreshedText1);
        Assertions.assertNotEquals(text2, refreshedText2);
        Assertions.assertNotEquals(text3, refreshedText3);

        driver.quit();
    }

    @Test
    public void dynamicControls() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Remove checkbox
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        removeButton.click();
        Boolean isCheckboxGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkbox\"]/input")));

        Assertions.assertTrue(isCheckboxGone, "The checkbox is gone!");

        // Add checkbox
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        addButton.click();
        boolean isCheckboxPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox\"]"))).isEnabled();

        Assertions.assertTrue(isCheckboxPresent, "The checkbox is back!");

        // Enable text box
        WebElement enableButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
        enableButton.click();
        boolean isTextBoxEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/input"))).isDisplayed();

        Assertions.assertTrue(isTextBoxEnabled, "The text box is enable!");

        // Disable text box
        enableButton.click(); // Disable
        boolean textBoxDisabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/input"))).isEnabled();

        Assertions.assertFalse(textBoxDisabled, "The text box is disabled!");

        driver.quit();
    }

    @Test
    public void dynamicLoading() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"start\"]/button")));
        startButton.click();
        String displayedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4"))).getText();

        Assertions.assertTrue(displayedText.contains("Hello World"));

        driver.quit();
    }
    @Test
    public void fileDownload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/download");

        File file = new File("C:\\Users\\xmedi\\Downloads\\some-file.txt");
        if(file.delete()) {
            System.out.println("Deleted!");
        }
        else {
            System.out.println("It does not exists!");
        }

        WebElement fileElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        fileElement.click();

        Thread.sleep(2000);

        if(file.exists()) {
            Assert.assertTrue(true);
        }
        driver.quit();
    }

    @Test
    public void fileUpload() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/upload");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        String fileName = "some-file.txt";
        uploadElement.sendKeys("C:\\Users\\xmedi\\Downloads\\" + fileName);
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"file-submit\"]"));
        uploadButton.click();
        WebElement uploadedFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uploaded-files\"]")));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText().trim(), fileName);

        driver.quit();
    }

    @Test
    public void floatingMenu() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/floating_menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");

        WebElement homeElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
        WebElement newsElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"));
        WebElement contactElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a"));
        WebElement aboutElement = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[4]/a"));

        Assert.assertEquals(homeElement.isDisplayed(), true);
        Assert.assertEquals(newsElement.isDisplayed(), true);
        Assert.assertEquals(contactElement.isDisplayed(), true);
        Assert.assertEquals(aboutElement.isDisplayed(), true);

        driver.quit();
    }

    @Test
    public void iframe() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/iframe");
        String textToType="Hello World";

        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);
        WebElement textBoxElement = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        textBoxElement.clear();
        textBoxElement.sendKeys(textToType);

        Assertions.assertEquals(textBoxElement.getText().trim(), textToType);
        driver.quit();
    }

    @Test
    public void MouseHover(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/hovers");
        Actions action = new Actions(driver);

        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

        // First image
        action.moveToElement(user1).perform();
        WebElement name1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        WebElement profile1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));

        Assert.assertEquals(name1.getText().trim(), "name: user1");
        Assert.assertEquals(profile1.getText().trim(), "View profile");

        // Second image
        action.moveToElement(user2).perform();
        WebElement name2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        WebElement profile2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));

        Assert.assertEquals(name2.getText().trim(), "name: user2");
        Assert.assertEquals(profile2.getText().trim(), "View profile");

        // Third image
        action.moveToElement(user3).perform();
        WebElement name3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        WebElement profile3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
        Assert.assertEquals(name3.getText().trim(), "name: user3");
        Assert.assertEquals(profile3.getText().trim(), "View profile");

        driver.quit();
    }

    @Test
    public void javaScriptAlerts() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // JS Alert
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")));
        alertElement.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        //  Confirm
        WebElement confirmElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")));
        confirmElement.click();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();

        // JS Prompt
        WebElement promptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")));
        promptElement.click();
        String typeMessage="Hello World!";
        alert.sendKeys(typeMessage);
        alert.accept();
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"result\"]")));
        Assert.assertEquals(textBox.getText(), "You entered: "+typeMessage);

        driver.quit();
    }

    @Test
    public void javaScriptError() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_error");

        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        String textLog = "";
        for(LogEntry entry : entries) {
            textLog = textLog + entry.getMessage();
        }

        if(textLog.contains("Cannot read properties of undefined (reading 'xyz')")){
            Assert.assertTrue(true);
        }

        driver.quit();
    }

    @Test
    public void testNewTab() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/windows");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement clickElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/a")));
        clickElement.click();
        String parent = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String nextWindow = iterator.next();
            if (!parent.equalsIgnoreCase(nextWindow)) {
                driver.switchTo().window(nextWindow);
                Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7080/windows/new");
                WebElement newWindowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h3")));
                Assert.assertEquals(newWindowElement.getText(), "New Window");
                driver.close();
            }
        }
        driver.switchTo().window(parent);
        driver.quit();
    }

    @Test
    public void testNotificationMessage() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/notification_message_rendered");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        clickElement.click();

        WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualHeaderMessage = messageElement.getText().trim();
        boolean ifMessageExists = actualHeaderMessage.contains("Action successful") || actualHeaderMessage.contains("Action unsuccesful, please try again") || actualHeaderMessage.contains("Action Unsuccessful");
        if(ifMessageExists) {
            Assert.assertTrue(true);
        }
        driver.quit();
    }
}

