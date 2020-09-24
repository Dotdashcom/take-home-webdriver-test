import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Tests {


        WebDriver driver;

        public static LoginPage loginSteps;

        @BeforeMethod
        public void getDriver() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            loginSteps= new LoginPage(driver);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }


        @Test
        public void LoginSuccess(){
            driver.get("http://localhost:7080/login");
            loginSteps.username.sendKeys("tomsmith");
            loginSteps.password.sendKeys("SuperSecretPassword!");
            loginSteps.login.submit();
            WebElement actualMessage = driver.findElement(By.className("subheader"));
            String actual = actualMessage.getText();
            String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
            Assert.assertEquals(actual, expectedMessage);

        }

        @Test
        public void LoginFailure() throws InterruptedException {
            driver.get("http://localhost:7080/login");
            loginSteps.username.sendKeys("tomsmith");
            loginSteps.password.sendKeys("SuperSecretPassw");
            loginSteps.login.submit();
            WebElement actualMessage = driver.findElement(By.id("flash"));
            Assert.assertTrue(actualMessage.getText().contains("Your password is invalid!"));

        }
        @Test
        public void newTab() {
            driver.get("http://localhost:7080/windows");
            System.out.print(driver.getTitle());
            driver.findElement(By.cssSelector(".example a")).click();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            Assert.assertEquals("New Window", driver.getTitle());}

        @Test
        public void CheckBoxes(){
            driver.get("http://localhost:7080/checkboxes");
            List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
            for (WebElement checkbox : checkBoxes) {
                checkbox.click();
            }
            Assert.assertTrue(checkBoxes.get(0).getAttribute("checked").equals("true"));
            Assert.assertNull(checkBoxes.get(1).getAttribute("checked"));

        }

        @Test
        public void ContextMenu()  {
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
        public void dropdownMenu() {
            driver.get("http://localhost:7080/dropdown");
            WebElement drop = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(drop);
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
        }

        @Test
        public void dragAndDrop() {
            driver.get("http://localhost:7080/drag_and_drop");
            WebElement boxA = driver.findElement(By.id("column-a"));
            WebElement boxB = driver.findElement(By.id("column-b"));
            Actions action = new Actions(driver);
            action.dragAndDrop(boxA, boxB).perform();
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='column-a']/header")).getText(), "A");
        }


        @Test
        public void DynamicContent() {
            driver.get("http://localhost:7080/dynamic_content?with_content=static");
            driver.findElement(By.xpath("//div//p[2]//a")).click();
            WebElement textInit = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]"));
            String textValueInit = textInit.getText();
            driver.navigate().refresh();
            driver.navigate().refresh();
            WebElement textRefreshed = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]"));
            String textValueRefreshed = textRefreshed.getText();
            Assert.assertNotEquals(textValueRefreshed, textValueInit);
        }
        @Test
        public void dynamicControls() {
            driver.get("http://localhost:7080/dynamic_controls");
            WebElement checkbox = driver.findElement(By.id("checkbox"));
            driver.findElement(By.xpath("//button[text()='Remove']")).click();
            Wait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.invisibilityOf(checkbox));
            boolean isPresent = (driver.findElements(By.id("checkbox"))).size()>0;
            Assert.assertFalse(isPresent);
            driver.findElement(By.xpath("//*[@id='checkbox-example']//button")).click();
            wait.until(ExpectedConditions.textToBe((By.xpath("//*[@id='message']")),"It's back!"));
            String message = driver.findElement(By.xpath("//p[@id = 'message']")).getText();
            Assert.assertEquals(message, "It's back!");
        }

        @Test
        public void fileUpload() {
            driver.get("http://localhost:7080/upload");
            Actions act = new Actions(driver);
            WebElement downloadBtn = driver.findElement(By.id("file-upload"));
            downloadBtn.sendKeys(System.getProperty("user.dir")+"/src/testdata/downloads/info.png");
            driver.findElement(By.id("file-submit")).click();
            Assert.assertEquals("File Uploaded!", driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

        }

        @Test
        public void iFrame() {
            driver.get("http://localhost:7080/iframe");
            WebElement frame = driver.findElement(By.id("mce_0_ifr"));
            driver.switchTo().frame(frame);
            WebElement textBox = driver.findElement(By.id("tinymce"));
            textBox.clear();
            textBox.sendKeys("Hello");
            driver.switchTo().defaultContent();
            WebElement sentence = driver.findElement(By.xpath("//*[@id='content']//h3"));
            Assert.assertEquals(sentence.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
        }


        @Test
        public void MouseHover(){
            driver.get("http://localhost:7080/hovers");
            Actions actions= new Actions(driver);
            WebElement pic= driver.findElement(By.className("figure"));
            System.out.print( pic.getText());
            actions.moveToElement(pic).perform();
            WebElement actual = driver.findElement(By.xpath("//*[@class='figcaption']/h5[contains(text(),'user1')]"));
            Assert.assertEquals(actual.getText(),"name: user1");
        }

        @Test
        public void JavaScriptAlerts() {

            driver.get("http://localhost:7080/javascript_alerts");
            WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
            jsAlert.click();
            Alert newAlert = driver.switchTo().alert();
            Assert.assertEquals("I am a JS Alert", newAlert.getText());
            newAlert.accept();
        }

        @Test
        public void JavaScriptError(){
            driver.get("http://localhost:7080/javascript_error");
            WebElement button =driver.findElement(By.xpath("//body"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);", button);
            String expectedText = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
            Assert.assertEquals(expectedText,button.getText());
        }


        @Test
        public void NotificationMessage() {
            driver.get("http://localhost:7080/notification_message_rendered");
            driver.findElement(By.cssSelector(".example a")).click();
            String text = driver.findElement(By.id("flash")).getText();
            System.out.print(text);
            Assert.assertTrue(text.trim().contains("Action successful\n" +
                    "×"));
        }

        @Test
        public void loading() {
            driver.get("http://localhost:7080/dynamic_loading/2");
            driver.findElement(By.xpath("//div[@id='start']/button")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@id='finish']/h4")));
            WebElement a1 = driver.findElement(By.xpath("//div[@id='finish']/h4"));
            Assert.assertEquals(a1.getText(), "Hello World!");
        }



    }




