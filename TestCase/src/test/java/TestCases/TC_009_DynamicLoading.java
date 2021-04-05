package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009_DynamicLoading extends BaseClass
{
    @Test (priority=9) //Test case for Dynamic Loading
    public void Dynamic_Loading_2()
    {
        //Launching Dynamic loading Url
        driver.get(BaseUrl+"dynamic_loading/2");
        //Explicit Wait Using WebDriverwait
        WebDriverWait mywait = new WebDriverWait(driver, 10);
        //Inspecting the WebElement for Start Button
        WebElement StrtBtn= driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        StrtBtn.click();
        //Using Explicit wait on Text element to display the text
        WebElement text=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        String AssText=driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
        System.out.println(AssText);
        //Using Assertion to test "Hello World ! text is displaying or not
        if(AssText.equals("Hello World!"))
        {
            Assert.assertTrue(true);
            System.out.println("Text is displayed");
        }
        else
        {
            Assert.assertTrue(false);
            System.out.println("Text is not Displayed");
        }
    }
}
