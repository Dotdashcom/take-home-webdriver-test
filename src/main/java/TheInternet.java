import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.SAAJResult;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheInternet extends TestBase {

    @Test
    public void loginSuccessfully(){

        driver.get("http://localhost:7080/login ");
        WebElement userNameBox = driver.findElement(By.id("username"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userNameBox.sendKeys("tomsmith");
        passwordBox.sendKeys("SuperSecretPassword!");
        loginButton.click();
        WebElement actualMessage = driver.findElement(By.tagName("h4"));
        Assert.assertEquals(actualMessage.getText(),"Welcome to the Secure Area. When you are done click logout below.");

    }


    @Test
    public void loginFailure(){

        driver.get("http://localhost:7080/login ");
        WebElement userNameBox = driver.findElement(By.id("username"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userNameBox.sendKeys("tomsmith2");
        passwordBox.sendKeys("SuperSecretPassword");
        loginButton.click();
        WebElement actualMessage = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualMessage.getText(),
                "Your username is invalid!"+"\n×");

    }

@Test
    public void checkBoxes(){

        driver.get("http://localhost:7080/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        Assert.assertTrue(!checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkBox2.isSelected());
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());
        checkBox2.click();
         Assert.assertTrue(!checkBox2.isSelected());

}

@Test
    public void ContextMenu(){

        driver.get("http://localhost:7080/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue((alert.getText()).equals("You selected a context menu"));

}

@Test
    public void dragAndDrop(){

        driver.get("http://localhost:7080/drag_and_drop");
        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);

    String actualMessage= BrowserUtils.getText(boxB);
    String expectedMessage="B";
    Assert.assertEquals(actualMessage,expectedMessage);
    actions.dragAndDrop(boxA,boxB).perform();
    boxB=driver.findElement(By.id("column-a"));
    String actualAfterDragAndDrop= BrowserUtils.getText(boxB);
    String expectedAfterDragAndDrop="A";
    Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
}

 @Test
    public void dropDawn(){
        driver.get("http://localhost:7080/dropdown");
        WebElement dropBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropBox);
        select.selectByValue("1");
        WebElement option1 = driver.findElement(By.xpath("//option[@value='1']"));
        Assert.assertTrue(option1.isSelected());
        String actual = option1.getText();
        String expected = "Option 1";
        Assert.assertEquals(actual,expected);


     select.selectByValue("2");
     WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));
     Assert.assertTrue(option2.isSelected());
     String actual1 = option2.getText();
     String expected1 = "Option 2";
     Assert.assertEquals(actual1,expected1);

 }
@Test
public void dynamicContent() {
        driver.get("http://localhost:7080/dynamic_content ");
    List<String> expected = new ArrayList<>();
    List<WebElement> texts = driver.findElements(By.xpath("//div[@class=\"large-10 columns\"]"));
    for(int i = 0; i<texts.size();i++){
        expected.add(texts.get(i).getText());
    }
    driver.navigate().refresh();
    driver.navigate().refresh();

    texts = driver.findElements(By.xpath("//div[@class=\"large-10 columns\"]"));

    List<String> actual = new ArrayList<>();
    for(int i = 0; i<texts.size();i++){
        actual.add(texts.get(i).getText());

    }
    Assert.assertNotEquals(actual, expected);
}

//@Test
//    public void dynamicControls()  {
//        driver.get("http://localhost:7080/dynamic_controls");
//        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
//        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
//        checkBox.click();
//        removeButton.click();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='message']"))));
//  Assert.assertTrue(message.isDisplayed());
//}

   @Test
   public void  dynamicLoading() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");
       WebElement startButton = driver.findElement(By.xpath("//button"));
       startButton.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='finish']//h4"))));
       Assert.assertTrue(BrowserUtils.getText(text).equals("Hello World!"));

   }

    @Test
    public void validateFileUpload(){
        driver.get("http://localhost:7080/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/ainursulaimanova/Desktop/usa.png");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement text = driver.findElement(By.xpath("//h3"));
        String actualText = text.getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void scrollIntoView(){
        driver.get("http://localhost:7080/floating_menu ");
        WebElement text = driver.findElement(By.xpath("//div[@class='scroll large-10 columns large-centered']"));
        BrowserUtils.scrollWithJS(driver,text);
        Assert.assertTrue(text.isDisplayed());
    }

   @Test
    public void iFrame(){

        driver.get("http://localhost:7080/iframe");
       driver.switchTo().frame("mce_0_ifr");
       WebElement message=driver.findElement(By.xpath("//body[@id='tinymce']"));
       String actualMessage = message.getText().trim();
       String expectedMessage = "Your content goes here.";
       Assert.assertEquals(actualMessage,expectedMessage);
   }

    @Test
    public void hoverOver() throws InterruptedException {

        driver.get("http://localhost:7080/hovers");

        List<WebElement> allNames = driver.findElements(By.tagName("h5"));
        List<WebElement> allPictures = driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedName = Arrays.asList("name: user1","name: user2","name: user3");
        List<String> actualName = new ArrayList<>();
        Actions actions = new Actions(driver);
        for (int i =0; i<allNames.size(); i++){
            actions.moveToElement(allPictures.get(i)).perform();
            Thread.sleep(3000);
            actualName.add(BrowserUtils.getText(allNames.get(i)));

        }
        Assert.assertEquals(actualName,expectedName);

    }

    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();// update our driver to automation
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage ="I am a JS Alert";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You successfully clicked an alert"));
    }

    @Test
    public void alertDismiss() {
        driver.get("http://localhost:7080/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS Confirm";
        Assert.assertEquals(actualMessage, expectedMessage);
        alert.dismiss();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You clicked: Cancel"));

    }

    @Test
    public void alertSendKeys() {
        driver.get("http://localhost:7080/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("SDET");
        alert.accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(BrowserUtils.getText(result).equals("You entered: SDET"));

    }

    @Test
    public void window(){
        driver.get("http://localhost:7080/windows ");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        String mainId = driver.getWindowHandle();
        BrowserUtils.switchByID(driver,mainId);
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(BrowserUtils.getText(text).equals("New Window"));
    }

    @Test
    public void notificationMessage(){
        driver.get(" http://localhost:7080/notification_message_rendered");
        WebElement clickBox = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        clickBox.click();
        WebElement message = driver.findElement(By.id("flash"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "Action successful"+"\n×";
        Assert.assertEquals(actualMessage,expectedMessage);
        clickBox.click();
        String actualMessage1 = message.getText().trim();
        String expectedMessage1 = "Action unsuccessful, please try again"+"\n×";
        Assert.assertEquals(actualMessage1,expectedMessage1);


    }

    @Test
    public void notificationMessage2(){
        driver.get(" http://localhost:7080/notification_message_rendered");
        WebElement clickBox = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickBox).perform();
        actions.doubleClick(clickBox).perform();
        WebElement message = driver.findElement(By.id("flash"));
        String actualMessage = message.getText().trim();
        String expectedMessage1 = "Action unsuccessful, please try again"+"\n×";
        Assert.assertEquals(actualMessage,expectedMessage1);

    }






   }








