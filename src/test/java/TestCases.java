import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        //setting path of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C://Users//Kjuri//Documents//Chromedriver//chromedriver.exe");

        //to launch the chrome browser window
        driver = new ChromeDriver();

        //maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    // Test is able to login successfully.
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);

        // Open Login page
        driver.get(loginPage.getUrl());

        // Login with username "tomsmith" and password "SuperSecretPassword!"
        loginPage.login("tomsmith", "SuperSecretPassword!");

        // Verify that the login was successful based on the page URL
        Assert.assertEquals(driver.getCurrentUrl(), securePage.getUrl(),
                "Login not successful, secure page was not loaded");

        // THIS IS IF WE WANT TO USE A WAIT INSTEAD OF JUST ASSERT TO ACCOUNT FOR LOAD TIME
        // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        //         .withTimeout(Duration.ofSeconds(10))
        //         .pollingEvery(Duration.ofSeconds(2));
        //
        // wait.until(ExpectedConditions.urlMatches(internetSecurePage.getUrl()));
    }

    @Test
    // Test is not able to login with wrong credentials.
    public void loginFailure() {
        LoginPage loginPage = new LoginPage(driver);
        // Open Login page
        driver.get(loginPage.getUrl());

        // Test wrong username
        loginPage.login("fakeUsername", "fakePassword");

        // check if there's a username error
        Assert.assertTrue(loginPage.hasUsernameError(),
                "Does not show username error on incorrect username");

        // Test wrong username
        loginPage.login("tomsmith", "fakePassword");

        // check if there's a password error
        Assert.assertTrue(loginPage.hasPasswordError(),
                "Does not show password error on incorrect password");
    }

    @Test
    // Test checks and unchecks checkboxes
    public void checkboxVerify() {
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        // Open checkbox page
        driver.get(checkboxPage.getUrl());

        // Save current select values
        boolean checkbox1IsChecked = checkboxPage.checkbox1IsChecked();
        boolean checkbox2IsChecked = checkboxPage.checkbox2IsChecked();

        // Select both checkboxes
        checkboxPage.clickCheckbox1();
        checkboxPage.clickCheckbox2();

        // Verify values are no longer the same as before
        Assert.assertNotEquals(checkbox1IsChecked, checkboxPage.checkbox1IsChecked(),
                "Checkbox 1 did not change select status when clicked.");

        Assert.assertNotEquals(checkbox2IsChecked, checkboxPage.checkbox2IsChecked(),
                "Checkbox 2 did not change select status when clicked.");

        // Select both checkboxes
        checkboxPage.clickCheckbox1();
        checkboxPage.clickCheckbox2();

        // Verify values are changed back
        Assert.assertEquals(checkbox1IsChecked, checkboxPage.checkbox1IsChecked(),
                "Checkbox 1 did not change select status when clicked.");

        Assert.assertEquals(checkbox2IsChecked, checkboxPage.checkbox2IsChecked(),
                "Checkbox 2 did not change select status when clicked.");
    }

    @Test
    // Test right clicks on the context menu.
    public void contextBoxVerify() {
        ContextPage contextPage = new ContextPage(driver);
        // Open Context page
        driver.get(contextPage.getUrl());

        // Right click context box
        contextPage.rightClickContextBox();

        // Check if an alert was created
        try {
            contextPage.accessAlert();
        } catch (NoAlertPresentException e) {
            Assert.fail("No alert was created on right click");
        }

        // Verify text is as expected
        Assert.assertEquals(contextPage.getAlertText(), "You selected a context menu",
                "Text in the alert does not equal \"You selected a context menu\"");
    }
}