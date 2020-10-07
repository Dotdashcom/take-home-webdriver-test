package dotdash;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class ALL_18_TestCases extends Base_Setup
{
    /**
     * This is Contains All 18 Tests Required
     * Most of the Variable Names are Lengthy, they are designed to be understandable by any Readers.
     *
     * Using java version "1.8.0_251"
     * Using webdrivermanager 4.0.0 through POM.XML
     * Using selenium-java 3.141.59 through POM.XML
     * Using TestNG_6.8 through POM.XML
     * Code is written in IntelliJ IDEA IntelliJ IDEA 2020.1.2 (Community Edition)
     * Written By Anvesh Poluri, Email: anvesh.poluri@gmail.com, Date: October_6_2020
     */

    @BeforeClass // Before Every Class Run this runs Browser Settings that invokes Chrome Browser and make sure browser is ready
    public void setUp()
    {
        Base_Setup.Browser_Settings();
    }
    @Test ()
   public void Test_Login_Success()
    {
        Load_URL("login"); // Opening Login URl Page
        // Finding the UserName Text Box and Sending Username = tomsmith
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        // Finding the password Text Box and Sending Username = SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();  // Clicking Login Button
        String Secure_Area_Message = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h4[1]")).getText(); // Reading Secure Message after Logging In
        // Validating the Test_Login_Success by comparing Secure_Area_Message with the expected Message
        assertEquals(Secure_Area_Message, "Welcome to the Secure Area. When you are done click logout below.");
    }
    @Test (priority = 1)
    public void Test_Login_Failure()
    {
        Load_URL("login");  // Opening Login URl Page
        // Finding the UserName Text Box and Sending Username = wrong_username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("wrong_username");
        // Finding the password Text Box and Sending Username = wrong_password!
        driver.findElement(By.id("password")).sendKeys("wrong_password!");
        driver.findElement(By.cssSelector("button.radius")).click(); // Clicking Login Button
        String Error_Message = driver.findElement(By.cssSelector("div#flash")).getText(); // Reading Error Message for Login Failure
        // Validating the Test_Login_Failure by comparing Error_Message with the expected Message
        assertTrue(Error_Message.contains("Your username is invalid!"));
    }
    @Test (priority = 2)
    public void Test_CheckBoxes()
    {
        Load_URL("checkboxes "); // Opening checkboxes URl Page
        // Storing all Available Checkboxes in a List
        List<WebElement> list_of_check_Boxes = new ArrayList<>(driver.findElements(By.xpath("//input[@type='checkbox']")));
        //Loop Going through each checkbox from list_of_check_Boxes and validating if it is Selected or Not
        // If it is Not Selected we are making sure check all Boxes.
        for (WebElement element : list_of_check_Boxes)
        {
            if (!element.isSelected()) // Validating if Current CheckBox is Not Selected
            {
                element.click(); // Clicking current Checkbox
            }
            // Validating the Test_CheckBoxes by making sure all checkboxes are selected
            assertTrue(element.isSelected(), "Checkbox is selected");
        }
    }
    @Test  (priority = 3)
    public void Test_ContextMenu()
    {
        Load_URL("context_menu ");  // Opening context_menu URl Page
        WebElement box_on_screen = driver.findElement(By.cssSelector("div#hot-spot")); // Finding the box_on_screen
        Actions act = new Actions(driver); // Declaring Actions Class for act
        act.contextClick(box_on_screen).perform(); // Right Clicking on the box_on_screen through Actions
        String Alert_Message = driver.switchTo().alert().getText(); // Getting Alert_Message
        //Validating the Test_ContextMenu by comparing the Alert_Message with the Expected
        Assert.assertEquals(Alert_Message, "You selected a context menu");
        driver.switchTo().alert().accept(); // Driver Switching to Alerts to accept the alert
    }

    @Test (priority = 4)
    public void Test_Drag_and_Drop()
    {
        Load_URL("drag_and_drop ");  // Opening drag_and_drop URl Page
        WebElement Box_A = driver.findElement(By.cssSelector("div#column-a")); // Finding Box_A
        WebElement Box_B = driver.findElement(By.cssSelector("div#column-b")); // Finding Box_B
        Actions act = new Actions(driver); // Declaring Actions Class act
        act.dragAndDrop(Box_B, Box_A).build().perform(); // Drags the element Box_B from one point and drops to another point Box_A
        // Validating the Test_Drag_and_Drop by making sure Box_B moved to Box_A
        Assert.assertEquals(Box_A.getText(), "A");
    }
    @Test (priority = 5)
    public void Test_dropdown()
    {
        Load_URL("dropdown"); // Opening dropdown URl Page
        WebElement dropDown = driver.findElement(By.cssSelector("select#dropdown")); // Finding the Dropdown List
        Select Dropdown_list = new Select(dropDown); // Declaring Select Class for Dropdown_list
        Dropdown_list.selectByVisibleText("Option 2"); // Selecting Option 2 from dropdown by using visible text
        String Text_of_selected_option = Dropdown_list.getFirstSelectedOption().getText(); // Getting text value from the current selected option in dropdown list
        //Validating Test_dropdown By Comparing text Text_of_selected_option with the Expected
        Assert.assertEquals(Text_of_selected_option,"Option 2");
        Dropdown_list.selectByVisibleText("Option 1");// Selecting Option 1 from dropdown by using visible text
        Text_of_selected_option = Dropdown_list.getFirstSelectedOption().getText(); // Getting text value from the current selected option in dropdown list
        //Validating Test_dropdown By Comparing text Text_of_selected_option with the Expected
        Assert.assertEquals(Text_of_selected_option,"Option 1");
    }
    @Test (priority = 6)
    public void Test_Dynamic_Content()
    {
        Load_URL("dynamic_content"); // Opening dynamic_content URl Page
        // Before Refreshing the Page we are finding the content_1
        WebElement content_1 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        // Getting before_refresh_content_1_Text from content_1
        String before_refresh_content_1_Text = content_1.getText();
        driver.navigate().refresh();// Refreshing the current page
        // After Refreshing the Page we are finding the content_2
        WebElement content_2 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        // Getting after_first_refresh_content_2_Text from content_2
        String after_first_refresh_content_2_Text = content_2.getText();
        // Validating Test_Dynamic_Content By Comparing before_refresh_content_1_Text and after_first_refresh_content_2_Text
        Assert.assertNotEquals(before_refresh_content_1_Text, after_first_refresh_content_2_Text);
        driver.navigate().refresh();// Refreshing the current page
        // After Second Refreshing the Page we are finding the content_3
        WebElement content_3 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
        // Getting after_Second_refresh_content_3_Text from content_3
        String after_Second_refresh_content_3_Text = content_3.getText();
        // Validating Test_Dynamic_Content By Comparing after_first_refresh_content_2_Text and after_Second_refresh_content_3_Text
        Assert.assertNotEquals(after_first_refresh_content_2_Text, after_Second_refresh_content_3_Text);
    }
    @Test (priority = 7)
    public void Test_Dynamic_Controls()
    {

        Load_URL("dynamic_controls"); // Opening dynamic_controls URl Page
        WebDriverWait wait = new WebDriverWait(driver, 20); // Creating Explicit Wait
        driver.findElement(By.xpath("//button[@type='button']")).click(); // Removing the CheckBox
        // Waiting Until Checkbox is Removed and Message is Generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        // Getting assert_txt which is Confirmation of Removing CheckBox
        String assert_txt = driver.findElement(By.xpath("//p[@id='message']")).getText();
        // Validating Test_Dynamic_Controls after Removing Checkbox by comparing assert_txt and expected Message
        Assert.assertEquals(assert_txt,"It's gone!");
        driver.findElement(By.xpath("//button[@type='button']")).click(); // Adding Check Box Once Again
        // Waiting Until Checkbox is Added and Message is Generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        // Getting assert_txt which is Confirmation of Adding the CheckBox
        assert_txt = driver.findElement(By.xpath("//p[@id='message']")).getText();
        // Validating Test_Dynamic_Controls after Re-Adding the Checkbox by comparing assert_txt and expected Message
        Assert.assertEquals(assert_txt,"It's back!");
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click(); // Clicking the Enable TextBox
        // Waiting Until TextBox is Enabled and Message is Generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        // Getting assert_txt which is Confirmation of TextBox is Enabled
        assert_txt  = driver.findElement(By.xpath("//*[@id='message']")).getText();
        // Validating Test_Dynamic_Controls after TextBox is Enabled by comparing assert_txt and expected Message
        Assert.assertEquals(assert_txt, "It's enabled!");
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click(); // Clicking the disable TextBox
        // Waiting Until TextBox is disabled and Message is Generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        // Getting assert_txt which is Confirmation of TextBox is disabled
        assert_txt  = driver.findElement(By.xpath("//*[@id='message']")).getText();
        // Validating Test_Dynamic_Controls after TextBox is disabled by comparing assert_txt and expected Message
        Assert.assertEquals(assert_txt, "It's disabled!");
    }
    @Test(priority = 8)
    public void Test_Dynamic_Loading()
    {
        Load_URL("dynamic_loading/2"); // Opening dynamic_loading/2 URl Page
        driver.findElement(By.xpath("//*[@id='start']/button")).click(); // Clicking Start Button
        WebDriverWait wait = new WebDriverWait(driver, 20); // Creating Explicit Wait
        // Waiting Until Hello World! Message is Generated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
        // Finding the Hello World! and loading its text to assert_txt_dynamic_loading
        String assert_txt_dynamic_loading = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
        // Validating Test_Dynamic_Loading after Hello World is Displayed by comparing assert_txt_dynamic_loading and expected Message
        Assert.assertEquals(assert_txt_dynamic_loading,"Hello World!");
    }
    @Test (priority = 9)
    public void Test_File_Download() throws InterruptedException
    {
        // *************** Download PAth Needs TO Be Updated Below ***********
        String downloadPath = "C:\\Users\\anvesh\\Downloads"; // Download path needs to be updated for every different PC
        Load_URL("download"); // Opening download URl Page
        driver.findElement(By.xpath("//a[contains(text(),'file.txt')]")).click(); // Clicking on Some-File.txt to download it
        Thread.sleep(2000); // Waiting until the file is downloaded completely
        //Validating Test_File_Download By Making sure the file is Downloaded using Check_for_Downloaded_file method
        Assert.assertTrue(Check_for_Downloaded_file(downloadPath, "some-file.txt"),"Failed to download Expected document");
    }
    @Test (priority = 10)
    public void Test_File_Upload()
    {

        Load_URL("upload"); // Opening upload URl Page
        WebElement Upload_Web_Element = driver.findElement(By.cssSelector("input#file-upload")); // Finding the Choose File Button
        // Make Sure some-file.txt is present in current project folder at SRC/some-file.txt
        Upload_Web_Element.sendKeys(System.getProperty("user.dir") + "/src/some-file.txt"); // Sending the some-file.txt to upload
        driver.findElement(By.cssSelector("input[type='submit']")).click(); // Clicking on Upload Button
        //Validating the Test_File_Upload By File Uploaded Success Message
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example")).getText(), "File Uploaded!" + "\n" + "some-file.txt");
    }
    @Test (priority = 11)
    public void Test_Floating_Menu()
    {
        Load_URL("floating_menu"); // Opening floating_menu URl Page
        WebElement Floating_Menu_Element = driver.findElement(By.xpath("//*[@id='menu']")); // Finding the FFloating Menu
        JavascriptExecutor jse = (JavascriptExecutor)driver; // Creating a JavaScript Executor for driver
        jse.executeScript("window.scrollBy(0,3000)", ""); // Scrolling Current Window to Bottom
        // Even after the page is SScrolled to Bottom we should validate if Floating Menu is Visible or Not
        // Validating Test_Floating_Menu By Making Sure Floating_Menu_Element is Displayed even after page is Scrolled
        Assert.assertTrue(Floating_Menu_Element.isDisplayed());
        driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/a")).click(); // Clicking on one of the Floating Menu Button
    }
    @Test (priority = 12)
    void Test_Iframe()
    {
        Load_URL("iframe"); // Opening iframe URl Page
        WebElement frame_element = driver.findElement(By.cssSelector("iframe[id*='ifr']")); // Fining the frame_element
        driver.switchTo().frame(frame_element); // Switching driver to Frame
        driver.findElement(By.cssSelector("body#tinymce")).clear(); // Clearing the Text Box inside the Frame
        // Sending Text to TextBox inside the Frame
        driver.findElement(By.cssSelector("body#tinymce")).sendKeys("Text is typed in Frame!!!");
        // Validating Test_Iframe by making sure typed message and displayed message are the same
        Assert.assertEquals(driver.findElement(By.cssSelector("body#tinymce")).getText(), "Text is typed in Frame!!!");
    }
    @Test (priority = 13)
    public void Test_Mouse_Hover() throws InterruptedException
    {
        Load_URL("hovers"); // Opening hovers URl Page
        Actions act =new Actions(driver);  // Declaring Actions Class act
        // Moving Mouse Pointer to Hover on First Image
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"))).build().perform();
        Thread.sleep(1000); // Waiting
        // Validating Test_Mouse_Hover, By Comparing the text displayed while mouse point hovers with the expected Message
        Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText(),"name: user1");
        // Moving Mouse Pointer to Hover on Second Image
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"))).build().perform();
        Thread.sleep(1000); // Waiting
        // Validating Test_Mouse_Hover, By Comparing the text displayed while mouse point hovers with the expected Message
        Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText(),"name: user2");
        // Moving Mouse Pointer to Hover on First Image
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"))).build().perform();
        Thread.sleep(1000); // Waiting
        // Validating Test_Mouse_Hover, By Comparing the text displayed while mouse point hovers with the expected Message
        Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText(),"name: user3");
    }
    @Test (priority = 14)
    public void Test_JavaScript_Alerts() throws InterruptedException
    {
        Load_URL("javascript_alerts"); // Opening javascript_alerts URl Page
        // Finding the JavaScript_Alert Button
        WebElement JavaScript_Alert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        // Finding the JavaScript_Confirm Button
        WebElement JavaScript_Confirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        // Finding the JavaScript_Prompt Button
        WebElement JavaScript_Prompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));

        JavaScript_Alert.click(); // Clicking on the JavaScript_Alert Button
        Alert alert = driver.switchTo().alert(); // Switching driver to the Alert
        // Validating the Test_JavaScript_Alerts, By Comparing the Alert Message with the Expected
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept(); // Accepting the Alert
        Thread.sleep(2000); // Waiting
        // Getting Result_Message After Accepting the Alert
        String Result_Message = driver.findElement(By.xpath("//*[@id='result']")).getText();
        // Validating the Test_JavaScript_Alerts, By CComparing the Result_Message with the Expected
        Assert.assertEquals(Result_Message,"You successfuly clicked an alert");

        JavaScript_Confirm.click();// Clicking on the JavaScript_Confirm Button
        // Validating the Test_JavaScript_Alerts, By Comparing the Alert Message with the Expected
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept(); // Accepting the Alert
        Thread.sleep(2000);// Waiting
        // Getting Result_Message After Accepting the Alert
        Result_Message = driver.findElement(By.xpath("//*[@id='result']")).getText();
        // Validating the Test_JavaScript_Alerts, By CComparing the Result_Message with the Expected
        Assert.assertEquals(Result_Message,"You clicked: Ok");

        JavaScript_Prompt.click();// Clicking on the JavaScript_Prompt Button
        // Validating the Test_JavaScript_Alerts, By Comparing the Alert Message with the Expected
        alert.sendKeys("sent text into JS Prompt"); // Sending text into the alert pop-up
        alert.accept(); // Accepting the Alert
        Thread.sleep(2000);// Waiting
        // Getting Result_Message After Accepting the Alert
        Result_Message = driver.findElement(By.xpath("//*[@id='result']")).getText();
        // Validating the Test_JavaScript_Alerts, By CComparing the Result_Message with the Expected
        Assert.assertEquals(Result_Message,"You entered: sent text into JS Prompt");
    }
    @Test (priority = 15)
    void Test_JavaScript_Error() throws InterruptedException
    {
        // Before Executing the Test_JavaScript_Error we are closing the current Browser and tearing down everything for Safety
        Base_Setup.tearDown(); // Tearing down and Closing all Browser and driver related operations
        Base_Setup.Browser_Settings(); // Restarting the Chrome Browser once again
        Load_URL("javascript_error"); // Opening javascript_error URl Page
        Thread.sleep(1000); // Waiting
        String ExpectedError = "Cannot read property 'xyz' of undefined"; // Expected Error Message
        // Loading all Log Entries of Browser into Java_Script_Error
        LogEntries Java_Script_Error = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry error : Java_Script_Error)
        {
            // Validating Test_JavaScript_Error, by Comparing Log Entries with the Expected Message.
            assertTrue(error.getMessage().contains(ExpectedError));
            break;
        }
    }
    @Test (priority = 16)
    public void Test_Open_in_New_Tab()
    {
        Load_URL("windows"); // Opening windows URl Page
        String parentWindowHandle = driver.getWindowHandle(); // Getting Parent Window Handle
        driver.findElement(By.linkText("Click Here")).click(); // Clicking on 'clickHere' Link
        // Loading the all the available window Handles into set_of_window_handles
        Set<String> set_of_window_handles=driver.getWindowHandles();
        // Creating Iterator for the set_of_window_handles
        // Loop Going through each Window Handle
        for (String child_window_handle : set_of_window_handles)
        {
            if (!parentWindowHandle.equals(child_window_handle)) // If Current Window Handle is not Same as Parent Window Handle
            {
                driver.switchTo().window(child_window_handle); // Switching driver to the child_window_handle
                // Validating the Test_Open_in_New_Tab, By Making Sure link opened a New Tab and Expected Message is Displayed
                Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText(), "New Window");
            }
        }
        driver.switchTo().window(parentWindowHandle); // Switching driver to the parentWindowHandle
        // Validating the Test_Open_in_New_Tab, By Making sure driver Switched Back to Parent Window and Expected Message is Displayed
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText(),"Opening a new window");

    }
    @Test (priority = 17)
    public void Test_notification_message()
    {
        Load_URL("notification_message_rendered"); // Opening notification_message_rendered URl Page
        // Creating to Loop, Every Time we Click on 'ClickHere' a Notification is Displayed
        // EAch Time We Click we get a New notification MMessage
        // Inorder to cover all notification Scenarios we are running the code in the loop of 4 expecting all notification Message are Rendered
        for (int i = 0; i<=4;i++)
        {
            driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click(); // Clicking on the Link 'ClickHere'
            // After Clicking Getting text of rendered Notification Message
            String Notification_Message = driver.findElement(By.xpath("//*[@id='flash']")).getText();
            if (Notification_Message.contains("Action unsuccessful, please try again"))// Validating Scenario-1
            {
                // Validating Test_notification_message, By Comparing Notification_Message with the Expected Message
                assertTrue(Notification_Message.contains("Action unsuccessful, please try again"));
            }
            else if (Notification_Message.contains("Action successful")) // Validating Scenario-2
            {
                // Validating Test_notification_message, By Comparing Notification_Message with the Expected Message
                assertTrue(Notification_Message.contains("Action successful"));
            }
        }
    }
    @AfterClass // After Every Class this tears down Browser and Drivers and Closes Everything
    public void TearDown()
    {
        Base_Setup.tearDown();
    }
}