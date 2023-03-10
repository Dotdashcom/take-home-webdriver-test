package com.example.takehomewebdrivertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageElementTest {
    private WebDriver driver;
    private static final String BaseUrl = "http://localhost:7080/";
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void checkBoxes(){
        driver.get(BaseUrl+"checkboxes");
        WebElement checkbox1 = driver.findElement(By
                .xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By
                .xpath("//*[@id='checkboxes']/input[2]"));
        //Verify first condition
        Assertions.assertFalse(checkbox1.isSelected());
        Assertions.assertTrue(checkbox2.isSelected());
        //click
        checkbox1.click();
        checkbox2.click();
        //Verify last condition
        Assertions.assertTrue(checkbox1.isSelected());
        Assertions.assertFalse(checkbox2.isSelected());
    }
    @Test
    public void contextMenu(){
        driver.get(BaseUrl+"context_menu");
        WebElement spot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //Right Click
        actions.contextClick(spot).perform();
        //Verify pop up
        assert(driver.switchTo()
                .alert()
                .getText()
                .equals("You selected a context menu"));
    }
    @Test
    public void dragAndDrop(){
        driver.get(BaseUrl+"drag_and_drop");
        WebElement columnA = driver.findElement(By
                .xpath("//*[@id='column-a']"));
        WebElement columnB = driver.findElement(By
                .xpath("//*[@id='column-b']"));
        //Actions action = new Actions(driver);
        //action.dragAndDrop(columnA, columnB).build().perform();
        //action.clickAndHold(columnA).moveToElement(columnB).release().build().perform();
        dragAndDropAction(columnA, columnB, driver);
        assert(columnA.getText().equals("B"));
        assert(columnB.getText().equals("A"));
    }
    //Helper Drag-And-Drop-Action
    private static void dragAndDropAction(WebElement source, WebElement target, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +
                "  var event = document.createEvent(\"CustomEvent\");\n" +
                "  event.initCustomEvent(typeOfEvent, true, true, null);\n" +
                "  event.dataTransfer = {\n" +
                "    data: {},\n" +
                "    setData: function (key, value) {\n" +
                "      this.data[key] = value;\n" +
                "    },\n" +
                "    getData: function (key) {\n" +
                "      return this.data[key];\n" +
                "    }\n" +
                "  };\n" +
                "  return event;\n" +
                "}\n" +
                "\n" +
                "function dispatchEvent(element, event, transferData) {\n" +
                "  if (transferData !== undefined) {\n" +
                "    event.dataTransfer = transferData;\n" +
                "  }\n" +
                "  if (element.dispatchEvent) {\n" +
                "    element.dispatchEvent(event);\n" +
                "  } else if (element.fireEvent) {\n" +
                "    element.fireEvent(\"on\" + event.type, event);\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "function simulateHTML5DragAndDrop(element, target) {\n" +
                "  var dragStartEvent = createEvent('dragstart');\n" +
                "  dispatchEvent(element, dragStartEvent);\n" +
                "  var dropEvent = createEvent('drop');\n" +
                "  dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);\n" +
                "  var dragEndEvent = createEvent('dragend');\n" +
                "  dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);\n" +
                "}\n" +
                "\n" +
                "var source = arguments[0];\n" +
                "var target = arguments[1];\n" +
                "simulateHTML5DragAndDrop(source, target);", source, target);
    }
    @Test
    public void dropDown(){
        driver.get(BaseUrl+"dropdown");
        Select menu = new Select(driver.findElement(By.id("dropdown")));
        //Verify Option 1 selected
        menu.selectByValue("1");
        assert(menu.getFirstSelectedOption().getText().equals("Option 1"));
        //Verify Option 2 selected
        menu.selectByValue("2");
        assert(menu.getFirstSelectedOption().getText().equals("Option 2"));
    }
    @Test
    public void floatingMenu(){
        driver.get(BaseUrl+"floating_menu");
        // Scroll the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement floatingMenu = new WebDriverWait(driver,
                Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("menu")));
        // Assert that the floating menu is displayed
        Assertions.assertTrue(floatingMenu.isDisplayed());
    }
    @Test
    public void iframe(){
        driver.get(BaseUrl+"iframe");
        //For close warning from Tiny Cloud
        driver.findElement(By
                .xpath("/html/body/div[4]/div/div/button/div")).click();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        //Adding text
        WebElement inputField = driver.findElement(By.id("tinymce"));
        inputField.sendKeys("Hello, World! ");
        String actualText = inputField.getText();
        assert(actualText.equals("Hello, World! Your content goes here."));
    }
    @Test
    public void mouseHover(){
        driver.get(BaseUrl+"hovers");
        for(int i=1; i<4; i++){
            String path = String.format("//*[@id='content']/div/div[%d]", i);
            WebElement image = driver.findElement(By.xpath(path));
            Actions actions = new Actions(driver);
            actions.moveToElement(image).perform();
            WebElement additionalInfo = driver.findElement(By.xpath(path+"/div/h5"));
            Assertions.assertTrue(additionalInfo.isDisplayed());
        }
    }
    @Test
    public void notificationMessageRendered(){
        driver.get(BaseUrl+"notification_message_rendered");
        WebElement button = driver.findElement(By
                .xpath("//*[@id='content']/div/p/a"));
        button.click();
        WebElement alert = driver.findElement(By.id("flash"));
        String alertMessage = alert.getText();
        int newLineIndex = alertMessage.indexOf("\n");
        alertMessage = alertMessage.substring(0, newLineIndex);
        Assertions.assertTrue(alertMessage.equals("Action successful")
                || alertMessage.equals("Action unsuccesful, please try again")
                || alertMessage.equals("Action unsuccessful"));
    }
}