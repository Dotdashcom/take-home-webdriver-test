package Test;

import Utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TakeHomeTest {


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.get("http://localhost:7080");
    }

    /*
        Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
         */
    @Test
    public void LoginSuccess() {
        driver.get("http://localhost:7080/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash success']")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    /*
    Login Failure: http://localhost:7080/login Login fail invalid creadentials
     */

    @Test
    public void LoginFailure() {
        driver.get("http://localhost:7080/login");
        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys((CharSequence) faker.funnyName());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys((CharSequence) faker.name());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "our password is invalid!";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash success']")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


/*
CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
 */

    @Test
    public void CheckBoxesTest1() {
        driver.get("http://localhost:7080/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //to verify if checkbox 1 is not selected
        if (!checkbox1.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        //to verify if checkbox 2 is selected

        if (checkbox2.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }

    @Test
    public void CheckBoxesTest2() {
        driver.get("http://localhost:7080/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        checkbox1.click(); // to select it
        SeleniumUtils.waitPlease(2);
        checkbox2.click();
        SeleniumUtils.waitPlease(2);
        if (checkbox1.isSelected() && (!checkbox2.isSelected())) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }

    /*
    ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'.
    Test JavaScript alert text on Right-Click.
     */
    @Test
    public void ContextMenu() {
        driver.get("http://localhost:7080/context_menu");
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();
        Alert alert = driver.switchTo().alert();

        alert.accept();

    }
//

    /*
    Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
     */
    @Test
    public void DragAndDrop() {
        driver.get("http://localhost:7080/drag_and_drop");
        Actions action = new Actions(driver);
        //hover on element
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));
        SeleniumUtils.waitPlease(2);
        action.dragAndDrop(a, b).perform();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(a.getText(), "A");
        Assert.assertEquals(b.getText(), "B");

    }

    /*
    Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
     */
    @Test
    public void Dropdown() {
        driver.get("http://localhost:7080/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select dropdownSelect = new Select(dropdown);
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(expected, actual);

        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }


    /*
    Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
     */
    @Test
    public void dynamicContent() {
        driver.get("http://localhost:7080/dynamic_content");
        String firstLineText = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        driver.navigate().refresh();
        String firstLineTextafterRefresh = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        Assert.assertFalse(firstLineText.contentEquals(firstLineTextafterRefresh));

    }

    /*
    Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
     */
    @Test
    public void dynamicControls() {
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']"));
        String buttonText = removeButton.getText();
        System.out.println(buttonText);
        Assert.assertEquals("Remove", buttonText);
        removeButton.click();
        SeleniumUtils.waitPlease(5);
        String buttonTextAfterClick = removeButton.getText();
        System.out.println(buttonTextAfterClick);
        Assert.assertEquals("Add", buttonTextAfterClick);

    }

    //Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
    @Test
    public void dynamicLoading() {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        SeleniumUtils.waitPlease(6);
        WebElement helloWorldButton = driver.findElement(By.xpath("//div[@id='finish']"));
        String actualWord = helloWorldButton.getText();
        Assert.assertEquals(actualWord, "Hello World!");

    }

    //File Download: http://localhost:7080/download Test File Download.
    @Test
    public void FileDownloaded() {

        driver.get("http://localhost:7080/download");
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();
        //change the file path in your code to the Downloads folder location
        String loadPath = "/Users/mohammedkashgari/Downloads";
        System.out.println(loadPath);
        String fileName = "some-file.txt";
        File dir = new File(loadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                System.out.println("file is downloaded");
            }

        }
    }

    //File Upload: http://localhost:7080/upload Test File Upload.
    @Test
    public void FileUpload() {

        driver.get("http://localhost:7080/upload");
        WebElement addButton = driver.findElement(By.id("file-upload"));
        //change the file path in your code to the Downloads folder location
        String filePath = "/Users/mohammedkashgari/SeleniumTest.docx";
        System.out.println(filePath);
        addButton.sendKeys(filePath);
        SeleniumUtils.waitPlease(4);
        driver.findElement(By.id("file-submit")).click();
        String fileName = "SeleniumTest.docx";
        SeleniumUtils.waitPlease(4);
        WebElement upLoadedFile = driver.findElement(By.id("uploaded-files"));
        if (upLoadedFile.getText().contentEquals(fileName)) {
            Assert.assertTrue(true, "file Uploaded");
            System.out.println(upLoadedFile.getText());
        } else {
            Assert.assertTrue(false, "file not Uploaded");
        }
    }

    //Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    @Test
    public void FloatingManue() {
        driver.get("http://localhost:7080/floating_menu");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement homeButton = driver.findElement(By.xpath("//a[@href='#home']"));
        WebElement newsButton = driver.findElement(By.xpath("//a[@href='#news']"));
        WebElement contactButton = driver.findElement(By.xpath("//a[@href='#contact']"));
        WebElement aboutButton = driver.findElement(By.xpath("//a[@href='#about']"));
        SeleniumUtils.waitPlease(3);
        if (homeButton.isDisplayed() && newsButton.isDisplayed() && contactButton.isDisplayed() && aboutButton.isDisplayed()) {
            System.out.println("All the floating buttons are displayed when you scroll down the page");
        } else
            System.out.println("There are something wrong");
        ////
    }

    //Iframe: http://localhost:7080/iframe Test iframe.
    @Test
    public void iframeTest() {
        driver.get("http://localhost:7080/iframe");
        driver.switchTo().frame(0);
        WebElement iframeElement = driver.findElement(By.xpath("//body[@id='tinymce']"));
        // driver.switchTo().frame(iframeElement);
        String letterInIframe = iframeElement.getText();
        System.out.println(letterInIframe);
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals("Your content goes here.", letterInIframe, "You are successfully switch to iframe now");
        driver.switchTo().defaultContent();

    }

    //Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    @Test
    public void hoversTest() {
        driver.get("http://localhost:7080/hovers");
        Actions action = new Actions(driver);
        String firstImageLocator = "(//img)[2]";
        String user1TextLocator = "//a[@href='/users/1']/preceding-sibling::h5";
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        String expectedText = "name: user1";
        String actualText = driver.findElement(By.xpath(user1TextLocator)).getText();
        System.out.println(actualText);
        //verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
        Assert.assertEquals(actualText, expectedText);

    }

    //JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    @Test
    public void javascriptAlerts() {
        driver.get("http://localhost:7080/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String resultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You successfuly clicked an alert", resultText);
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        SeleniumUtils.waitPlease(2);
        String resultText2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Ok", resultText2);
        SeleniumUtils.waitPlease(3);


        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.accept();
        // alert3.sendKeys("Hello World");
        SeleniumUtils.waitPlease(3);
        String resultText3 = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered:", resultText3);
        SeleniumUtils.waitPlease(3);

    }


    //JavaScript Error: http://localhost:7080/javascript_error Test JS error.
    @Test
    public void javascriptError() {
        driver.get("http://localhost:7080/javascript_error");
        String text = driver.getTitle();
        System.out.println(text);
        Assert.assertEquals("Page with JavaScript errors on load", text);

    }

    //Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    @Test
    public void windows() {
        driver.get("http://localhost:7080/windows");
        String parent = driver.getWindowHandle();
        WebElement clickButton = driver.findElement(By.xpath("//a[@href='/windows/new' and @target='_blank']"));
        clickButton.click();
        SeleniumUtils.waitPlease(3);
        Set<String> s = driver.getWindowHandles();
// Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();

            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                String windwoTitle = driver.switchTo().window(child_window).getTitle();
                System.out.println(windwoTitle);
                Assert.assertEquals("New Window", windwoTitle);
                driver.close();
            }

        }
//switch to the parent window
        driver.switchTo().window(parent);

    }

    //Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.

@Test
private void notificationMessage() {
    driver.get("http://localhost:7080/notification_message_rendered");
    WebElement clickButton=driver.findElement(By.xpath("//a[@href='/notification_message']"));
    clickButton.click();
    WebElement expectedMessage=driver.findElement(By.xpath("//div[@id='flash-messages']"));

    System.out.println(expectedMessage.getText());
    Assert.assertTrue(expectedMessage.getText().contains("Action successful")
            ||expectedMessage.getText().contains("Action unsuccesful, please try again"));


}


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


