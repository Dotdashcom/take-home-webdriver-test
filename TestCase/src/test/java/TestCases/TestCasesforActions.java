package TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.api.robot.Key;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.*;
import pageObjects.LoginPage;

public class TestCasesforActions extends BaseClass
{
    @Test(priority=1)
    public void LoginTestPass()
    {
    	driver.get(BaseUrl);
    	LoginPage lp=new LoginPage(driver);
        lp.SetUserName(username);
        lp.SetPassword(password);
        lp.ClickLogin();
        
      if(driver.getPageSource().contains("You logged into a secure area!"))
        {
           Assert.assertTrue(true);
           System.out.println("logged into correct page");
        }
        else
        { 
           Assert.assertTrue(false);	
        }
    }
    
    @Test(priority=2)
    public void LoginTestFail()
    {
    	driver.get(BaseUrl);	
    	LoginPage lp=new LoginPage(driver);
    	lp.SetUserName(wrngUname);
    	lp.SetPassword(wrngPwd);
    	lp.ClickLogin();
    	if(driver.getPageSource().contains("You logged into a secure area!"))
        {
           Assert.assertTrue(true);
           System.out.println("logged into correct page");
        }
        else
        { 
           Assert.assertTrue(false);	
        }
    }

    @Test(priority=3)
    public void CheckBox()
    {
        driver.get("http://localhost:7080/checkboxes");
        WebElement chkbox1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        chkbox1.click();
        System.out.println(chkbox1.isSelected());
        chkbox1.click();
        System.out.println(chkbox1.isSelected());
      
        WebElement chkbox2=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
        chkbox2.click();
        System.out.println(chkbox2.isSelected());
        chkbox2.click();
        System.out.println(chkbox2.isSelected());
    }

    @Test(priority=4)
    public void ContextClick()
    {
    	driver.get("http://localhost:7080/context_menu");
    	WebElement contxtclk=driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
    	Actions act=new Actions(driver);
    	act.contextClick(contxtclk).build().perform();
    	driver.switchTo().alert().accept();
    }

    @Test(priority=5)
    public void DragAndDrop()
    {
    	driver.get("http://localhost:7080/drag_and_drop");
    	WebElement Source=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
    	WebElement Target=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
    	Actions act=new Actions(driver);
    	act.dragAndDrop(Source, Target).build().perform();
    }

    @Test(priority=6)
    public void DropDown()
    {
        driver.get("http://localhost:7080/dropdown");
        Select drpdwn=new Select(driver.findElement(By.id("dropdown")));
        drpdwn.selectByIndex(1);
    }

    @Test(priority=7)
    public void DynamicContentRefresh()
    {
    	driver.get("http://localhost:7080/dynamic_content");
    	driver.navigate().refresh();
    }

    @Test(priority=8)
    public void FileDownload()
    {
    	driver.get("http://localhost:7080/download");
    	driver.findElement(By.linkText("some-file.txt")).click();
    	driver.findElement(By.linkText("some-file (1).txt")).click();
    }
    		
    @Test(priority=9)
    public void FileUpload()
    {
    	driver.get("http://localhost:7080/upload");
    	WebElement Upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
    	Upload.click();

    	String txtfilepath="C:\\Users\\shahi\\Downloads\\some-file.txt";
    	Upload.sendKeys(txtfilepath);
    }
    
    @Test(priority=10)
    public void FloatingMenu()
    {
    	driver.get("http://localhost:7080/floating_menu");
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,4000)","");
    }
    
    @Test(priority=11)
    public void IFrame()
    {
    	driver.get("http://localhost:7080/iframe");//*[@id="content"]/div/div
    	WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
    	
    	driver.switchTo().frame(iFrame);
    	//driver.findElement(By.linkText("Edit")).click();
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[1]/span")).click();
    	//driver.findElement(By.xpath("//span[contains(text(),'Paragraph')]")).click();
    	//driver.findElement(By.id("tinymce")).sendKeys("Hello");
    }
    
    @Test(priority=12)
    public void MouseHover()
    {
    	driver.get("http://localhost:7080/hovers");
    	WebElement image1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
    	WebElement image2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
    	WebElement image3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
    	Actions act=new Actions(driver);
    	act.moveToElement(image1).moveToElement(image2).moveToElement(image3).click().build().perform();
    }
    
    @Test(priority=13)
    public void JSAlerts()
    {
    	driver.get("http://localhost:7080/javascript_alerts");
    	WebElement JSAlert=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
    	JSAlert.click();
    	driver.switchTo().alert().accept();
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
    	driver.switchTo().alert().dismiss();
    }
    
    @Test(priority=14)
    public void OpenNewWindow()
    {
    	driver.get("http://localhost:7080/windows");
    	System.out.println(driver.getWindowHandle());
    	driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //driver.navigate().forward();
        System.out.println(driver.switchTo().window (driver.getWindowHandle()));
        //driver.close();
    }
    
    @Test(priority=15)
    public void NotificationMsg()
    {
    	driver.get("http://localhost:7080/notification_message_rendered");
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
    	System.out.println(driver.findElement(By.id("flash")).getText());
    }
}
