package com.theInternet.StepDefinitions;

import com.theInternet.Pages.contextMenuPage;
import com.theInternet.Pages.dragAndDropPage;
import com.theInternet.Utilities.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class test {

    contextMenuPage contextMenuPage;
    dragAndDropPage dragAndDropPage = new dragAndDropPage();
    Actions actions;

    @Test
    public void test1() throws InterruptedException, AWTException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://localhost:7080/context_menu");
        driver.manage().window().fullscreen();
       // assertThat("Context Menu", is(contextMenuPage.contextMenuHeader.getText()));

        actions = new Actions(driver);
        By locator = By.id("hot-spot");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        Alert alert;
        actions.contextClick().build().perform();
        Thread.sleep(2000);
        alert = driver.switchTo().alert();
        alert.accept();
       // driver.switchTo().alert().accept();
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Test
    public void test5() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://localhost:7080/drag_and_drop");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        actions = new Actions(driver);
     //   String a = dragAndDropPage.boxA.getText();
       // System.out.println(a);
        actions.dragAndDrop(dragAndDropPage.boxA, dragAndDropPage.boxB).perform();
       // actions.moveToElement(dragAndDropPage.boxA).clickAndHold().moveToElement(dragAndDropPage.boxB).release().build().perform();



    }
}
