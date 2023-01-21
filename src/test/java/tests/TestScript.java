package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestPage;
import utils.Util;
import java.util.logging.Level;


public class TestScript extends BaseTest {

    TestPage testPage;


    @BeforeMethod
    public void localSetUp() {
        testPage = new TestPage(getDriver());

    }


    @Test(testName = "Login Success")
    public void test01() {
        getDriver().get("http://localhost:7080/login");
        testPage.userID.clear();
        testPage.sendKeys(testPage.userID, Util.USER_NAME);
        testPage.password.clear();
        testPage.sendKeys(testPage.password, Util.PASSWD);
        testPage.click(testPage.loginBtn);
        System.out.println(testPage.getText(testPage.loggedMsg));
        System.out.println(testPage.getText(testPage.welcomeSign));
        testPage.click(testPage.logoutBtn);

    }

    @Test(testName = "Login Failure")
    public void test02() {
        getDriver().get("http://localhost:7080/login");
        testPage.userID.clear();
        testPage.sendKeys(testPage.userID, Util.INVALID_USER_NAME);
        testPage.password.clear();
        testPage.sendKeys(testPage.password, Util.PASSWD);
        testPage.click(testPage.loginBtn);
        System.out.println(testPage.getText(testPage.logErrorMsg));

    }


    @Test(testName = "Check Boxes")
    public void test03() {
        getDriver().get("http://localhost:7080/checkboxes");
        testPage.click(testPage.checkBox1);
        testPage.click((testPage.checkBox2));


    }

    @Test(testName = "Context Menu")
    public void test04() {
        getDriver().get("http://localhost:7080/context_menu");
        Actions action = new Actions(getDriver());
        action.contextClick(testPage.boxSpot).release().perform();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();


    }

    @Test(testName = "Drag and Drop")
    public void test05() {
        getDriver().get("http://localhost:7080/drag_and_drop");
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(testPage.dropBoxA, testPage.dropBoxB).build().perform();


    }

    @Test(testName = "Dropdown")
    public void test06() {
        getDriver().get("http://localhost:7080/dropdown");
        Select select = new Select(testPage.dropDown);
        select.selectByVisibleText("Option 1");

    }

    @Test(testName = "Dynamic Content")
    public void test07() {
        getDriver().get("http://localhost:7080/dynamic_content");
        System.out.println("Text 1: " + testPage.getText(testPage.dynamicText));
        testPage.click(testPage.clickDynamicPage);
        System.out.println("Text 2: " + testPage.getText(testPage.dynamicText));
        testPage.click(testPage.clickDynamicPage);
        System.out.println("Text 3: " + testPage.getText(testPage.dynamicText));


    }

    @Test(testName = "Dynamic Controls")
    public void test08() {
        getDriver().get("http://localhost:7080/dynamic_controls");
        testPage.click(testPage.dynCheckBox);
        testPage.click(testPage.dynamicControlBtn);
        System.out.println(testPage.getText(testPage.messageText));


    }

    @Test(testName = "Dynamic Loading")
    public void test09() {
        getDriver().get("http://localhost:7080/dynamic_loading/2");
        testPage.click(testPage.startBtn);
        System.out.println(testPage.getText(testPage.helloWorldMsg));
    }

    @Test(testName = "File Download")
    public void test10() {
        getDriver().get("http://localhost:7080/download");
        testPage.click(testPage.downloadFile);
    }

    @Test(testName = "File Upload")
    public void test11() {
        getDriver().get("http://localhost:7080/upload");
        WebElement addFile = testPage.chooseFile;
        addFile.sendKeys("/Users/juliaumar/Desktop");
        testPage.click(testPage.uploadFile);


    }

    @Test(testName = "Floating Menu")
    public void test12() {
        getDriver().get("http://localhost:7080/floating_menu");
        Actions action = new Actions(getDriver());
        for (WebElement menu : testPage.floatingMenu) {
            action.moveToElement(menu).build().perform();
            menu.click();
        }
    }

    @Test(testName = "Iframe")
    public void test13() {
        getDriver().get("http://localhost:7080/iframe");
        testPage.click(testPage.closeAlertBtn);
        getDriver().switchTo().frame(testPage.iFrameBox);
        testPage.iFrameBox2.clear();
        testPage.iFrameBox2.sendKeys("Hello World!");
        getDriver().switchTo().parentFrame().switchTo().defaultContent();

    }

    @Test(description = "Mouse Hover")
    public void test14() {
        getDriver().get("http://localhost:7080/hovers");
        Actions actions = new Actions(getDriver());
        testPage.click(testPage.hover);
        actions.moveToElement(testPage.user1Btn).perform();


    }

    @Test(description = "JavaScript Alert")
    public void test15() {
        getDriver().get("http://localhost:7080/javascript_alerts");
        testPage.click(testPage.jsAlert1);
        Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(testPage.alertResult.getText());


    }

    @Test(description = "JavaScript Error")
    public void test16() {
        getDriver().get("http://localhost:7080/javascript_error");
        System.out.println(getDriver().findElement(By.xpath("//*[contains(text(), 'This page has a JavaScript error')]")).getText());
        LogEntries entries = getDriver().manage().logs().get(LogType.BROWSER);
        entries.filter(Level.SEVERE);
    }

    @Test(description = "Open in New Tab")
    public void test17() {
        getDriver().get("http://localhost:708");


    }

}














