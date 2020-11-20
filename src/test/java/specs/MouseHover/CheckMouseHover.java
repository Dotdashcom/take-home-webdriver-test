package specs.MouseHover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

import java.util.List;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #14 Mouse Hover: http://localhost:7080/hovers Test Mouse Hover
public class CheckMouseHover extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static By byFigure = By.className("figure");
    private static By byUserName = By.tagName("H5");
    private static By byViewProfile = By.xpath("//a[contains(@href, 'users')]");
    private static List<WebElement> elUserAvatars;
    private static List<WebElement> elUserNames;
    private static List<WebElement> elViewProfile;

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/hovers");
    }

    @Test
    public void checkMouseHover() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Actions actions = new Actions(driver);

        // Get User Avatars web elements
        elUserAvatars = driver.findElements(byFigure);

        // Handle MouseHover actions along User Avatars web elements
        for (int i=0; i<elUserAvatars.size(); i++) {
            actions.moveToElement(elUserAvatars.get(i)).build().perform();

            Thread.sleep(DEFAULT_PAUSE);

            // Validate User name label is displayed
            elUserNames = driver.findElements(byUserName);
            softas.assertTrue(elUserNames.get(i).isDisplayed(), "User name label is not displayed");

            // Validate View Profile label is displayed
            elViewProfile = driver.findElements(byViewProfile);
            softas.assertTrue(elViewProfile.get(i).isDisplayed(), "View Profile label is not displayed");
        }

        softas.assertAll();
    }

}
