import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Vector;

public class TestCases {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //setting path of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C://Users//Kjuri//Documents//Chromedriver//chromedriver.exe");

        //to launch the chrome browser window
        driver = new ChromeDriver();

        //maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    // Testcase 1
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
    // Testcase 2
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
    // Testcase 3
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
    // Testcase 4
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

        String alertText = contextPage.getAlertText();

        // Closing alert first in case of failure, to prevent future test cases
        // from breaking because of unexpected alert open
        contextPage.closeAlert();

        // Verify text is as expected
        Assert.assertEquals(alertText, "You selected a context menu",
                "Text in the alert does not equal \"You selected a context menu\"");
    }

    @Test
    // Testcase 5
    // Test drags element A to element B.
    public void dragDropVerify() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        // Open drag and drop page
        driver.get(dragAndDropPage.getUrl());

        String elementAText = dragAndDropPage.getAText();
        String elementBText = dragAndDropPage.getBText();

        // Drag and drop element A to element B
        dragAndDropPage.dragAtoB();

        // Assert that the text of the elements have been swapped after drag/drop
        Assert.assertEquals(dragAndDropPage.getAText(), elementBText);
        Assert.assertEquals(dragAndDropPage.getBText(), elementAText);
    }

    @Test
    // Testcase 6
    // Test selects Option 1 and Option 2 from the drop down menu.
    public void dropdownVerify() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        // Open dropdown page
        driver.get(dropdownPage.getUrl());

        dropdownPage.clickDropdown();
        dropdownPage.clickOption("Option 1");

        Assert.assertEquals(dropdownPage.getSelectedOption().getText(), "Option 1");

        dropdownPage.clickDropdown();
        dropdownPage.clickOption("Option 2");

        Assert.assertEquals(dropdownPage.getSelectedOption().getText(), "Option 2");
    }

    @Test
    // Testcase 7
    // Test refreshes the page a couple of times.
    // Test asserts that the content changes on each refresh.
    public void dynamicContentVerify() {
        DynamicPage dynamicPage = new DynamicPage(driver);
        // Open dynamic content page
        driver.get(dynamicPage.getUrl());

        String[] imgSrcStrs = new String[3];
        String[] textDescStrs = new String[3];

        // get the initial values
        for (int i = 0; i < 3; i++) {
            imgSrcStrs[i] = dynamicPage.getRowImgSrc(i+1);
            textDescStrs[i] = dynamicPage.getRowText(i+1);
        }

        // refresh 5 times to reduce chance of false fail assertations
        for (int i = 0; i < 5; i++) {
            dynamicPage.refreshPage();
            // Compare image and text to see if there's a change
            for (int j = 0; j < 3; j++) {
                if (!imgSrcStrs[j].equals(dynamicPage.getRowImgSrc(j+1))) {
                    imgSrcStrs[j] = "";
                }
                if (!textDescStrs[j].equals(dynamicPage.getRowText(j+1))) {
                    textDescStrs[j] = "";
                }
            }
        }

        // Verify that all images have changed at least once
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(imgSrcStrs[i], "");
        }

        // Verify that all text has changed at least once
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(textDescStrs[i], "");
        }
    }
}