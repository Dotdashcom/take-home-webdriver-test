package shakilTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenInNewTabTest_17 extends TestBase {

    @Test
    public void testLinkOpensInNewTab() {
        driver.get("http://localhost:7080/windows");

        // Click the "Click Here" link
        driver.findElement(By.xpath("//div[@id='content']//a[@href='/windows/new']"))
                .click();

        // Get all window handles
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

        // Check that two tabs are open
        Assert.assertEquals(windowHandles.size(), 2, "Two tabs are not open");

        // Switch to the new tab
        driver.switchTo().window(windowHandles.get(1));

        // Verify that the new tab has the expected URL and text
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7080/windows/new",
                "New tab has incorrect URL");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3"))
                .getText(), "New Window", "New tab has incorrect text");
    }
}

// click here xpath //div[@id='content']//a[@href='/windows/new'] , new window url http://localhost:7080/windows/new 
// new window xpath //div[@class='example']/h3[.='New Window'] with innter text New Window 