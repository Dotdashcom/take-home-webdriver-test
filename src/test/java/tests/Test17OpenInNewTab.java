package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;

public class Test17OpenInNewTab extends GenericTest {

    @Test
    public void Test17OpenInNewTab() {
        String url = "http://localhost:7080/windows";
        driver.get(url);

        By clickHereLinkXpath = By.xpath("//div[@class='example']/descendant::a[text()='Click Here']");

        driver.findElement(clickHereLinkXpath).click();

        //get all tabs and switch to the new one
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        //check that title is appropriate
        Assert.assertEquals(driver.getTitle(),"New Window");

        driver.switchTo().defaultContent();
    }

}