package specs.DynamicContent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #7 Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload
public class CheckDynamicContent extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static By byContent = By.xpath("//div[contains(@class, 'large-10')]");

    // We may use this selector as well
    // private static By byContent = By.xpath("//div[@id='content']/div[2]");

    @BeforeMethod
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/dynamic_content");
    }

    @Test
    public void checkDynamicContent() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        // Refresh the page a few times
        for (int i=0; i<=5; i++) {
            WebElement elContent = driver.findElement(byContent);

            // Get the original content value
            String orgContent = elContent.getText();

            Thread.sleep(DEFAULT_PAUSE);

            // Refresh the page
            driver.navigate().refresh();

            // Initialize WebElement to get the content again
            WebElement elContentAfter = driver.findElement(byContent);

            // Get the content value after the page refresh
            String actContent = elContentAfter.getText();

            // Validate the content changed after the page refresh
            softas.assertFalse(orgContent.equals(actContent), "The content should change after the page refresh");
        }

        softas.assertAll();
    }

}
