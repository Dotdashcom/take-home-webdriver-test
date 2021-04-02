package dotDash;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TC116_NewTabWindow extends BaseClass {

    @Test
    public void newTabWindow() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "OpenInNewTab");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Click on Click here
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //Capture window handles
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String childTab = iterator.next();
        //Child Tab
        driver.switchTo().window(childTab);
        String childTitle = driver.getTitle();
        Assert.assertEquals(childTitle,"New Window");

    }
}