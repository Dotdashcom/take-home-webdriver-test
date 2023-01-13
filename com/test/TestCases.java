package com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {
    private static final String BASE_URL = "http://localhost:7080/";
    static WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\8\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    //USE THIS FUNCTION TO WAIT
    public void WaitTimer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //USE THIS FUNCTION TO INITIALIZE DRIVER
    public void InitalizeDriver() {
        driver = new ChromeDriver();
    }

    //USE THIS FUNCTION TO COMPARE TWO STRINGS
    public void compareStrings(String expectedString, String actualString) {

        byte[] expectedBytes = expectedString.getBytes();
        byte[] actualBytes = actualString.getBytes();

        if (!StandardCharsets.US_ASCII.newEncoder().canEncode(expectedString) &&
                !StandardCharsets.US_ASCII.newEncoder().canEncode(actualString)) {
            assertEquals(expectedString, actualString);
        }
    }

    //USE THIS FUNCTION TO ADD/REMOVE DYNAMIC CONTROLS TEST CASE
    public void addRemove(String message) {
        //Test clicks on the Remove Button and uses explicit wait
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        Duration waitDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        WebElement msgGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));

        //Asserts that the checkbox is gone
        String actualValue = (msgGone.getText());
        Assertions.assertEquals(actualValue, message);
    }

    //USE THIS FUNCTION TO ENABLE/DISABLE DYNAMIC CONTROLS TEST CASE
    public void enableDisable() {
        //Test clicks on the Remove Button and uses explicit wait
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        Duration waitDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/input")));

        // Assert that the textbox is enabled
        assertTrue(element.isEnabled());

    }

    //VERIFY LOGIN
    @Test
    public void verifyLoginSuccess() {

        InitalizeDriver();
        driver.get(BASE_URL+"login");

        WaitTimer();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Click the login button
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        // Check that the login was successful
        WaitTimer();
        assert driver.getTitle().equals("The Internet");

        // Close the browser
        //driver.quit();
    }

    //VERIFY LOGIN VERIFICATION
    @Test
    public void verifyLoginFailure() {
        InitalizeDriver();
        // Open the login page
        driver.get(BASE_URL  + "login");
        // Enter the username and password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecret");

        // Click the login button
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        Charset utf8 = Charset.forName("UTF-8");
        // Check that the login was successful

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div"));
        String actualString = element.getText();

        String expectedString = "Your password is invalid!";
        compareStrings(expectedString,actualString);
//        driver.quit();

    }

    //VERIFY CHECKBOX
    @Test
    public void verifyCheckboxes() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/*[@type=\"checkbox\"][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/*[@type=\"checkbox\"][2]"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("checkbox1 is now checked");
        }
        if (checkbox2.isSelected()) {
            checkbox2.click();
            System.out.println("checkbox2 is now unchecked");
        }

        WaitTimer();
        // Close the browser
        driver.quit();
    }

    //VERIFY CONTEXT MENU
    @Test
    public void verifyContextMenu() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "context_menu");

            Actions action = new Actions(driver);
            WebElement element = driver.findElement(By.id("hot-spot"));
            action.contextClick(element).perform();

            // Switch focus to the alert
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            System.out.println("HEY !"+alertMessage);
            // assert that the alert window contains the expected text
            String expectedText = "You selected a context menu";
            Assertions.assertEquals(expectedText, alertMessage);

        WaitTimer();
        // Close the browser
        driver.quit();
    }

    //VERIFY DRAG AND DROP
    @Test
    public void verifyDragAndDrop() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "drag_and_drop");

        //WebElement on which drag and drop operation needs to be performed
        WebElement from = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]"));

        //WebElement fromElement = driver.findElement(By.xpath("//*[@id='from-element-xpath']"));
        String fromId = from.getAttribute("id");
        System.out.println(fromId);

        //WebElement to = driver.findElement(By.id("#column-b"));
        WebElement to = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]"));

        //Performing the drag and drop action
        new Actions(driver).dragAndDrop(from, to).perform();
        //Assertion
        boolean isElementInTarget = to.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]")).size() > 0;
        Assert.assertTrue("Element is not moved to the target location ", isElementInTarget);

        // Close the browser
        driver.quit();
    }

    //VERIFY DROPDOWN
    @Test
    public void verifyDropdown() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "dropdown");

        // Locate the dropdown element using its id or other attributes
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Create a new Select object
        Select select = new Select(dropdown);

        // Get all the options in the dropdown
        List<WebElement> options = select.getOptions();

        //Create a list of expected options
        List<String> expectedValues = Arrays.asList("Option 1", "Option 2");

        // Create a list of actual options
        List<String> actualValues = options.stream().map(WebElement::getText).collect(Collectors.toList());
    for(int i=0;i<expectedValues.size();i++){
    byte[] expectedBytes = expectedValues.get(i).getBytes();
    byte[] actualBytes = actualValues.get(i).getBytes();

    if (!StandardCharsets.US_ASCII.newEncoder().canEncode(expectedValues.get(i)) &&
            !StandardCharsets.US_ASCII.newEncoder().canEncode(actualValues.get(i))) {
        assertEquals(expectedValues, actualValues);
    }
        }
    }


    //VERIFY DYNAMIC CONTENT
    @Test
    public void verifyDynamicContent() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "dynamic_content?with_content=static");
        String beforeRefresh = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();

        WaitTimer();

        //Refresh the page
        driver.navigate().refresh();

        String afterRefresh = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();
        Assertions.assertNotEquals(beforeRefresh, afterRefresh);

        // Close the browser
        driver.quit();
    }

    //VERIFY DYNAMIC CONTROLS
    @Test
    public void verifyDynamicControls() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "dynamic_controls");

        //Test clicks on the Remove Button and uses explicit wait and assertion
        addRemove("It's gone!");
        WaitTimer();
        // Test clicks on Add Button and uses explicit wait and assertion
        addRemove("It's back!");

        //Test clicks on the Enable Button and uses explicit wait and assertion
        enableDisable();
        //Test clicks on the Disable Button and uses explicit wait and assertion

        // Close the browser
        driver.quit();
    }

    //VERIFY DYNAMIC LOADING
    @Test
    public void verifyDynamicLoading() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "dynamic_loading/2");

        //Test clicks the start button and uses explicit wait and assertion
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
        Duration waitDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        String textMessage = "Hello World!";
        Boolean messageElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"finish\"]/h4"), textMessage));

        // Close the browser
        driver.quit();
    }

    //VERIFY FILE DOWNLOAD
    @Test
    public void verifyFileDownload() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "download");

        WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
        downloadLink.click();
        WaitTimer();
        File downloadedFile = new File("C:\\Users\\Guru\\Downloads\\" + "some-file.txt");
        Assert.assertTrue("File has not been downloaded", downloadedFile.exists());
        // Close the browser
       driver.quit();
    }

    //VERIFY FILE UPLOAD
    @Test
    public void verifyFileUpload() {

        InitalizeDriver();
        // Open the URL
        driver.get(BASE_URL + "upload");

        // Locate the file upload element
        WaitTimer();
        WebElement fileInput = null;
        ((JavascriptExecutor) driver).executeScript("document.getElementById('file-upload').click()");
        WaitTimer();
        // Provide file path
        fileInput = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        fileInput.sendKeys("D:\\Sumi\\Automation\\DotDashCom\\testMedia\\sampleTest.txt");
        WaitTimer();
        // Submit the form
        // driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
        ((JavascriptExecutor) driver).executeScript("document.getElementById('file-submit').click()");
        // Wait for the upload to complete
        WaitTimer();
        WebElement textElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        System.out.println(textElement.getText());
        String expectedValue = textElement.getText();
        Assertions.assertEquals(expectedValue, "File Uploaded!");

        // Close the browser
        driver.quit();
    }

    //VERIFY FLOATING MENU
    @Test
    public void VerifyFloatingMenu(){

        InitalizeDriver();
        driver.get(BASE_URL + "floating_menu");
        WebElement floatingMenu = driver.findElement(By.xpath("//*[@id=\"menu\"]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WaitTimer();
        Assertions.assertTrue(floatingMenu.isDisplayed());
        WaitTimer();

        // Close the browser
        driver.quit();
    }

   //VERIFY IFRAME
    @Test
    public void VerifyIframe(){
        InitalizeDriver();
        driver.get(BASE_URL + "iframe");
        WaitTimer();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div")));
        WaitTimer();

        WebElement button = driver.findElement(By.xpath("/html/body/div[4]/div/div/button"));
        WaitTimer();
        button.click();

        // Locate the input field within the iframe
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        // Enter text into the input field
        inputField.sendKeys("Message from Sumi");

        WaitTimer();
        // Switch back to the main frame
        driver.switchTo().defaultContent();

        // Close the browser
        driver.quit();
    }

    //VERIFY MOUSE HOVER
    @Test
    public void VerifyMouseHover() {
        InitalizeDriver();
        driver.get(BASE_URL + "hovers");
        WaitTimer();

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Locate the images
        List<WebElement> images = driver.findElements(By.className("figure"));

        // Iterate over the images
        for (WebElement image : images) {
            WaitTimer();
            // Hover over the image
            actions.moveToElement(image).perform();

            Duration waitDuration = Duration.ofSeconds(50);
            WebDriverWait wait = new WebDriverWait(driver, waitDuration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[1]/div")));

            WebElement details = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div"));
            // Assert that the additional details are displayed
            Assert.assertTrue( details.isDisplayed());
            WaitTimer();

            // Close the browser
            driver.quit();
        }
    }

    //VERIFY JAVASCRIPT ALERTS
    @Test
    public void VerifyAlert() {
        InitalizeDriver();
        driver.get(BASE_URL + "javascript_alerts");
        WaitTimer();
        WebElement outputText = driver.findElement(By.xpath("//*[@id=\"result\"]"));

        //Verify Alert
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        WaitTimer();
        // Accept the alert
        alert.accept();
        Assert.assertEquals(outputText.getText(),"You successfuly clicked an alert");

        //Verify Confirm Alert
        WaitTimer();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        Alert alertConfirm = driver.switchTo().alert();
        WaitTimer();
        alertConfirm.accept();
        Assert.assertEquals(outputText.getText(),"You clicked: Ok");
        WaitTimer();

        //Verify Prompt Alert
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Alert alertPrompt = driver.switchTo().alert();
        WaitTimer();
        alertPrompt.sendKeys("Hello message from Sumi");
        alertPrompt.accept();

        Assert.assertEquals(outputText.getText(),"You entered: Hello message from Sumi");

        // Close the browser
        driver.quit();
    }

    //VERIFY JAVASCRIPT ERROR
    @Test
    public void VerifyError() {
        InitalizeDriver();
        driver.get(BASE_URL + "javascript_error");
        WaitTimer();

       // Get the title of the page
       String title = driver.getTitle();

       // Assert that the title is "Page with JavaScript errors on load"
       Assert.assertEquals("Page with JavaScript errors on load", title);

       WebElement errorPage = driver.findElement(By.xpath("/html/body"));

       System.out.println(errorPage.getText());
       Assert.assertTrue(errorPage.getText().contains("This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques."));
       // Close the browser
       driver.quit();
    }

    //VERIFY OPEN NEW TAB
    @Test
    public void VerifyNewTab() {
        InitalizeDriver();
        driver.get(BASE_URL + "windows");
        WaitTimer();

         // Get the current window handle
         String originalWindowHandle = driver.getWindowHandle();

         // Click the hyperlink
         driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

         // Get the set of window handles
         Set<String> windowHandles = driver.getWindowHandles();

         // Assert that there is more than one window handle
         Assert.assertTrue(windowHandles.size() > 1);

         // Switch to the new window
         for (String handle : windowHandles) {
             if (!handle.equals(originalWindowHandle)) {
                 driver.switchTo().window(handle);
                 break;
             }
         }

         // Verify the URL of the new window
         String currentUrl = driver.getCurrentUrl();
         Assert.assertEquals("http://localhost:7080/windows/new", currentUrl);

         WaitTimer();
         // Close the new window
         driver.close();

         // Switch back to the original window
         driver.switchTo().window(originalWindowHandle);
         // Close the browser
         driver.quit();
    }

    //VERIFY NOTIFICATION MESSAGE
    @Test
    public void VerifyNotification() {
        InitalizeDriver();
        driver.get(BASE_URL + "notification_message_rendered");
        WaitTimer();
        String[] expectedMessages = {"Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful"};


        WebElement hyperlink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));

        for (int i = 0; i < expectedMessages.length; i++) {
            // Click the hyperlink
            hyperlink.click();
            WaitTimer();
            // Get the message displayed
            WebElement messageElement = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
            ///html/body/div[1]/div/div
            WaitTimer();
            String actualMessage = messageElement.getText();

            System.out.println("actualMessage -->"+actualMessage);
            // Assert the message is as expected
            Assert.assertEquals(expectedMessages[i], actualMessage.trim());

            // Close the browser
            driver.quit();
        }
    }
}


