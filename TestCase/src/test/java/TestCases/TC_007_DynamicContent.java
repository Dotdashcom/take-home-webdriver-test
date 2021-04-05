package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_007_DynamicContent extends BaseClass
{
    @Test (priority=7) // Test Case for Dynamic Content Refresh
    public void DynamicContentRefresh() throws InterruptedException
    {
        //Launching Url for Dynamic Refresh
        driver.get(BaseUrl+"dynamic_content");
        //navigating driver to refresh first time
        driver.navigate().refresh();
        //Putting some wait time to see driver refresh clearly for first refresh
        Thread.sleep(3000);
        //Checking PageSource Text After refresh the Page first time
        Assert.assertTrue(driver.getPageSource().contains("This example demonstrates the ever-evolving nature of content by loading new text and images on each page refresh."));

        //navigating driver to refresh the page second Time
        driver.navigate().refresh();
        //Putting some wait time to see driver refresh clearly for second refresh
        Thread.sleep(3000);
        //Checking PageSource Text After refresh the Page second time
        Assert.assertTrue(driver.getPageSource().contains("This example demonstrates the ever-evolving nature of content by loading new text and images on each page refresh."));

    }
}
