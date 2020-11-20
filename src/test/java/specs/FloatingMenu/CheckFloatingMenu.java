package specs.FloatingMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #12 Floating Menu: http://localhost:7080/floating_menu Test Floating Menu
public class CheckFloatingMenu extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static By byFloatingMenu = By.xpath("//div[@id='menu']");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/floating_menu");
    }

    @Test
    public void checkFloatingMenu() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        // Validate Floating Menu is displayed before scrolling
        softas.assertTrue(driver.findElement(byFloatingMenu).isDisplayed(),
                "Floating Menu is not displayed before scrolling");


        // Use JavascriptExecutor for a page scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(DEFAULT_PAUSE);

        // Validate Floating Menu is displayed after scrolling
        softas.assertTrue(driver.findElement(byFloatingMenu).isDisplayed(),
                "Floating Menu is not displayed after scrolling");

        softas.assertAll();
    }

}
