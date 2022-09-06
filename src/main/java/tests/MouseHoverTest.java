package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import pages.utils;

public class MouseHoverTest {
    MouseHoverPage mouseHoverPage;

    public MouseHoverTest() {
        mouseHoverPage = new MouseHoverPage();
    }

    @Test
    public void mouseHoverTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/hovers");

        Actions action = new Actions(driver);

        for (int i = 0; i < 3; i++) {
            WebElement element = mouseHoverPage.imageHover().get(i);
            utils.visibleElementWait(element);
            action.moveToElement(element).perform();

            if (mouseHoverPage.displayContent().get(i).isDisplayed()) {
                System.out.println(mouseHoverPage.displayContent().get(i).getText() + " is displayed");
            }
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



