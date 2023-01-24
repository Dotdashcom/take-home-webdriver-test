package tests;



import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest {
    WebDriver driver;

    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    void testLoginSuccess() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/login");
        loginPage.login("tomsmith", "SuperSecretPassword!");
        loginPage.loginSuccess();
    }

    @Test
    void testLoginFailure() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/login");
        loginPage.login("tomsmith", "password!");
        loginPage.loginFailure();
    }

    @Test
    void testCheckBoxSelected() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/checkboxes");
        loginPage.clickCheckBox();
        loginPage.validateCheckBoxSelected();
        loginPage.clickCheckBox();
        loginPage.validateCheckBoxUnSelected();
    }

    @Test
    void testContextMenu() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/context_menu");
        loginPage.clickContextMenu();
    }
    @Test
    void testDragDrop() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/drag_and_drop");
        loginPage.dragAndDrop();
    }

    @Test
    void testDropDown() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/dropdown");
        loginPage.dropDown();
    }

    @Test
    void testDynamicContent() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/dynamic_content");
        loginPage.dynamicContent();
    }
    @Test
    void testDynamicControls() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/dynamic_controls");
        loginPage.clickRemove();
        loginPage.clickAdd();
        loginPage.clickEnable();
    }

    @Test
    void testNewTab() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/windows");
        loginPage.clickLinkTab();
    }
    @Test
    void testIFrame() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/iframe");
        loginPage.enterFrame();
    }
    @Test
    void testJSAlerts() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchApplication("http://localhost:7080/javascript_alerts");

        String expText = "I am a JS Alert";
        String actText = loginPage.clickOnJSAlertBtn();
        Assert.assertTrue(expText.equals(actText));

        String expText2 = "I am a JS Alert";
        String actText2 = loginPage.clickOnJSconfirmBtn();
        System.out.println(actText);
        Assert.assertTrue(expText.equals(actText));

        String expText3 = "I am a JS prompt";
        String actText3 = loginPage.clickOnJSPromptBtn();
        Assert.assertTrue(expText.equals(actText));
    }
}

