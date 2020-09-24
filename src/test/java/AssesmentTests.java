import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

class Tests {

    WebDriver driver;

    public static POMLoginPage loginPage;

    @BeforeMethod
    public void getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new POMLoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void Verify_Login_With_Valid_Credentials() throws InterruptedException {
        driver.get("http://localhost:7080/login");
        loginPage.usernameInput.sendKeys("tomsmith");
        loginPage.passwordInput.sendKeys("SuperSecretPassword!");
        loginPage.loginInput.submit();
        WebElement actualMessage = driver.findElement(By.className("subheader"));
        String actual = actualMessage.getText();
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(actual, expectedMessage);

    }

    @Test
    public void Verify_Login_With_Invalid_Credentials() throws InterruptedException {
        driver.get("http://localhost:7080/login");
        loginPage.usernameInput.sendKeys("TestFailuretomsmith");
        loginPage.passwordInput.sendKeys("TestFailureSuperSecretPassword!");
        loginPage.loginInput.submit();
        WebElement actualMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(actualMessage.getText().contains("Your username is invalid!"));

    }

    @Test
    public void Verify_Check_Boxes() throws InterruptedException {
        driver.get("http://localhost:7080/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
        for (WebElement checkbox : checkBoxes) {
            checkbox.click();
        }
        Assert.assertTrue(checkBoxes.get(0).getAttribute("checked").equals("true"));
        Assert.assertNull(checkBoxes.get(1).getAttribute("checked"));

    }

    @Test
    public void Verify_Context_Menu() throws InterruptedException {
        driver.get("http://localhost:7080/context_menu");
        Actions click = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        click.contextClick(element).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        element.click();
    }

    @Test
    public void Verify_Drag_And_Drop() throws InterruptedException {
        driver.get("http://localhost:7080/drag_and_drop");
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action.dragAndDrop(elementA, elementB).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='column-a']/header")).getText(), "A");
    }

    @Test
    public void Verify_Dropdown() throws InterruptedException {
        driver.get("http://localhost:7080/dropdown");
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropDown);
        List<WebElement> menu = dropdown.getOptions();
        for (WebElement option : menu) {
            if (option.getText().equals("Option 1")) {
                option.click();
            }
        }
        for (WebElement option : menu) {
            if (option.getText().equals("Option 1")) {
                Assert.assertTrue(option.isSelected());
            }
        }
        for (WebElement option : menu){
            if(option.getText().equals("Option 2")){
                option.click();
            }
        }
        for (WebElement option : menu) {
            if (option.getText().equals("Option 2")) {
                Assert.assertTrue(option.isSelected());
            }
        }
    }

    @Test
    public void Verify_Dynamic_Content() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_content?with_content=static");
        driver.findElement(By.xpath("//div//p[2]//a")).click();
        WebElement text = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]"));
        String textValue = text.getText();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        WebElement textRefreshed = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]"));
        String textValueRefreshed = textRefreshed.getText();
        Assert.assertNotEquals(textValueRefreshed, textValue);
    }

    @Test
    public void Verify_Dynamic_Controls() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        Wait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        boolean isPresent = (driver.findElements(By.id("checkbox"))).size() > 0;
        Assert.assertFalse(isPresent);

        driver.findElement(By.xpath("//*[@id='checkbox-example']//button")).click();
        wait.until(ExpectedConditions.textToBe((By.xpath("//*[@id='message']")), "It's back!"));
        String message = driver.findElement(By.xpath("//p[@id = 'message']")).getText();
        Assert.assertEquals(message, "It's back!");

        driver.findElement(By.xpath("//*[@id='input-example']//button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
        String messageEnabled = driver.findElement(By.xpath("//p[@id = 'message']")).getText();
        Assert.assertEquals(messageEnabled, "It's enabled!");

        driver.findElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
        String messageDisabled = driver.findElement(By.xpath("//p[@id = 'message']")).getText();
        Assert.assertEquals(messageDisabled, "It's disabled!");

    }

    @Test
    public void Verify_Dynamic_Loading() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        WebElement a1 = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        Assert.assertEquals(a1.getText(), "Hello World!");

    }


    @Test
    public void Verify_File_Upload() throws InterruptedException {
        driver.get("http://localhost:7080/upload");
        Actions act = new Actions(driver);
        WebElement downloadButton = driver.findElement(By.id("file-upload"));
        downloadButton.sendKeys(System.getProperty("user.dir") + "/src/testdata/downloads/picture.png");
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);

        Assert.assertEquals("File Uploaded!", driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

    }

    @Test
    public void Verify_Floating_Menu(){
        driver.get("http://localhost:7080/floating_menu");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement floatingMenu = driver.findElement(By.xpath("//*[@id='menu']"));
        Assert.assertTrue(floatingMenu.isDisplayed());

    }

    @Test
    public void Verify_iFrame() throws InterruptedException {
        driver.get("http://localhost:7080/iframe");
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Test");
        driver.switchTo().defaultContent();
        WebElement sentence = driver.findElement(By.xpath("//*[@id='content']//h3"));
        Assert.assertEquals(sentence.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }


    @Test
    public void Verify_Hovers() throws InterruptedException {
        driver.get("http://localhost:7080/hovers");
        List<WebElement> listOfText = driver.findElements(By.cssSelector(".figure h5"));
            List<WebElement> listOfImages = driver.findElements(By.cssSelector(".figure img"));
            boolean resultAfterHower = true;
            Actions action = new Actions(driver);
            int i = 0;
            for (WebElement image : listOfImages) {
                action.moveToElement(image).perform();
                if (listOfText.get(i).isDisplayed()) {
                    resultAfterHower = resultAfterHower && true;
                    i++;
                }
            }
            Assert.assertTrue(resultAfterHower);
    }


    @Test
    public void Verify_JavaScript_Alerts() throws InterruptedException {
        driver.get("http://localhost:7080/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        Alert newAlert = driver.switchTo().alert();
        Assert.assertEquals("I am a JS Alert", newAlert.getText());
        newAlert.accept();

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Alert newConfirm =driver.switchTo().alert();
        Thread.sleep(3000);
        Assert.assertEquals("I am a JS Confirm",newConfirm.getText());
        newConfirm.accept();

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        Alert newPrompt =driver.switchTo().alert();
        newPrompt.sendKeys("New message");
        newPrompt.accept();

        WebElement newMessagePrompt = driver.findElement(By.xpath("//p[@id='result']"));
        String storedMessage = newMessagePrompt.getText();
        Assert.assertEquals("You entered: New message", storedMessage);
    }

    @Test
    public void Verify_JavaScript_Error() throws InterruptedException {
        driver.get("http://localhost:7080/javascript_error");
        String expectedError = "Uncaught TypeError: Cannot read property 'xyz' of undefined";
        boolean result = false;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
        if (entry.getMessage().contains(expectedError)){
        System.out.println(entry.getMessage());
        result = true;
      }
}
      Assert.assertTrue(result);
    }

    @Test
    public void Verify_NewTab() throws InterruptedException {
        driver.get("http://localhost:7080/windows");
        driver.findElement(By.cssSelector(".example a")).click();
        System.out.print(driver.getTitle());
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals("New Window", driver.getTitle());
    }

    @Test
    public void Verify_Notification_Message() throws InterruptedException {
        driver.get("http://localhost:7080/notification_message_rendered");
        driver.findElement(By.cssSelector(".example a")).click();
        String text = driver.findElement(By.id("flash")).getText();
        System.out.print(text);
        Assert.assertTrue(text.trim().contains("Action successful\n" +
                "×"));

    }
}
