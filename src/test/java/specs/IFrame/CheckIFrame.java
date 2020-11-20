package specs.IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #13 Iframe: http://localhost:7080/iframe Test iframe
public class CheckIFrame extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 4000;
    private static By byIFrame = By.id("mce_0_ifr");
    private static By byFrameBody = By.id("tinymce");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/iframe");
    }

    @Test
    public void checkIFrame() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        String expText = "Hello World!";

        // Use SwitchTo() method to handle another frame
        driver.switchTo().frame(driver.findElement(byIFrame));

        // Clear and type some text in the frame body
        WebElement elContentBody = driver.findElement(byFrameBody);
        elContentBody.clear();
        elContentBody.sendKeys(expText);

        Thread.sleep(DEFAULT_PAUSE);

        // Get the recently added text
        String actText = elContentBody.getText();

        // Validate the typed text has been added into ContentBody element correctly
        softas.assertTrue(actText.equals(expText),
                "The typed text has been not added into ContentBody element");

        driver.switchTo().defaultContent();

        softas.assertAll();
    }

}
