package Assignment;

import Pages.OpenInNewTabPage;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class OpenInNewTab extends TestBase {

        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);

    @Test
    public void openingNewTabTest(){


        driver.get(baseUrl + "/windows");

        getWait().until(ExpectedConditions.elementToBeClickable(openInNewTabPage.openNewWindowLink));
        openInNewTabPage.openNewWindowLink.click();

        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();



        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }

        String expectedText = "New Window";
        String actualText = openInNewTabPage.pageHeader.getText();

        Assert.assertEquals(actualText , expectedText , "The header text of the new window is not correct. actualText: " + actualText + "\nexpectedText: " + expectedText);
    }
}
