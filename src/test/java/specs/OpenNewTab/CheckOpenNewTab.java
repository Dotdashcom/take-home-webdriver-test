package specs.OpenNewTab;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #17 Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab
public class CheckOpenNewTab extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static By byNewTab = By.xpath("//a[@href='/windows/new']");
    private static By byNewTabText = By.tagName("h3");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/windows");
    }

    @Test
    public void checkOpenNewTab() throws Exception {
        SoftAssert softas = new SoftAssert();

        driver.findElement(byNewTab).click();
        Thread.sleep(DEFAULT_PAUSE);

        // Using WindowHandles to manage Browser tabs/windows
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        String parentTab = iterator.next();
        String childTab = iterator.next();

        // Move to Child Browser Tab
        driver.switchTo().window(childTab);
        Thread.sleep(DEFAULT_PAUSE);

        String actText = driver.findElement(byNewTabText).getText();

        // Validate a new tab is opened with text New Window
        softas.assertTrue(actText.equals("New Window"), "A new tab is not opened with text 'New Window'");

        // Move to Parent Browser Tab
        driver.switchTo().window(parentTab);
        Thread.sleep(DEFAULT_PAUSE);

        softas.assertAll();
    }

}
