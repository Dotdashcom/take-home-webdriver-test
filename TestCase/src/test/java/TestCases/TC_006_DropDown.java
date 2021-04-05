package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_006_DropDown extends BaseClass
{

    @Test (priority=6) //Test Case for DropDown
    public void DropDown() throws InterruptedException
    {
        //Launching DropDown Url
        driver.get(BaseUrl+"dropdown");
        String[] drpmenu={"Please select an option","Option 1","Option 2"};
        //Inspecting drop down using Select Class
        Select drpdwn = new Select(driver.findElement(By.id("dropdown")));

        //Find How many options in drop down menu
        System.out.println("No.of drop down options in dropdown menu :" + drpdwn.getOptions().size());
        int DrpdwnCount=drpdwn.getOptions().size();

        //Fetching DropDown Options from drop down menu
        List<WebElement> options = drpdwn.getOptions();
        for (WebElement e : options) {
            System.out.println(e.getText());
        }

        //Checking each Dropdown value and matching with expected value
        for(int i=1;i<DrpdwnCount;i++) {
            Assert.assertEquals(drpmenu[i],options.get(i).getText());
            System.out.println(options.get(i).getText());
        }

    }
}
