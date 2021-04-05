package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_ContextMenu extends BaseClass
{
    @Test (priority=4) //Test Case for Context menu
    public void ContextClick()
    {
        //Launching Context Menu Url
        driver.get(BaseUrl+"context_menu");
        //inspecting WebElement for Context click
        WebElement contxtclk=driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
        //Using Actions class for Mouse Operations
        Actions act=new Actions(driver);
        //Context click  on Box
        act.contextClick(contxtclk).build().perform();
        //Expecting  Alert Message from Alert Box
        String ExptAlrtMsg="You selected a context menu";
        //Fetching Alert text from alert box
        String ActualAlrtMsg=driver.switchTo().alert().getText();
        System.out.println(ActualAlrtMsg);
        //Asserting both Texts
        Assert.assertEquals(ExptAlrtMsg,ActualAlrtMsg);
        //Switching driver to accept the Alert menu text
        driver.switchTo().alert().accept();

    }

}
