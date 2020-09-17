package Doctest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CheckBoxPage;
import pageObjects.ContextPage;
import pageObjects.DownloadPage;
import pageObjects.DragDropPage;
import pageObjects.Dropdown;
import pageObjects.ExplicitWts;
import pageObjects.ExplictwtPage;
import pageObjects.IFramePage;
import pageObjects.JsalertPage;
import pageObjects.LoginPage;
import pageObjects.MouseHoverPage;
import pageObjects.NewTabPage;
import pageObjects.RefreshPage;
import pageObjects.UploadPage;
import resources.BaseDr;

public class LoginTest extends BaseDr {
	
	
	
public  WebDriver driver;

@BeforeTest

	public void initialize() throws IOException
	{
	driver = intializeDriver();
		 

	}

@Test ( priority = 1 )
	public void loginPassTest() throws IOException
	{
		
		driver.get(prop.getProperty("loginurl"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getLogin().click();
		
		
	}
	
	@Test ( priority = 2 )
	
	public void loginFailTest() throws IOException
	{
		driver.get(prop.getProperty("loginurl"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getLogin().click();
	}
	 
	@Test ( priority = 3 )
	
	 public void checkboxTest() 
	 {
		driver.get(prop.getProperty("checkboxesurl"));
		
		CheckBoxPage ch = new CheckBoxPage(driver);
		ch.getCheckBox().click();
		
		if (ch.getCheckBox2().isSelected())
		{
			ch.getCheckBox2().click();
		}
		
		}
	
@Test (priority = 4)
	
	public void dragAndDrop()
	{
		driver.get(prop.getProperty("dragdropurl"));
		
		DragDropPage dp = new DragDropPage(driver);
		
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(dp.getSourceLocator(), dp.getDestinationLocator()).perform();
				
		
	} 

	
	
	@Test (priority = 5 )
	public void dropDown()
	{
		driver.get(prop.getProperty("dropdown"));
		Dropdown dd = new Dropdown(driver);
		
		dd.getDropDownLocator().click();
		Select s = new Select(dd.getDropDownLocator());
		
		s.selectByVisibleText("Option 1");
	}
	

	
	

	@Test (priority = 6)
	
	public void refreshClick()
	{
		driver.get(prop.getProperty("dynamiccontent"));
		RefreshPage rp = new RefreshPage(driver);
		String beforeRefresh = rp.getRefreshContentLoc().getText();
		driver.navigate().refresh();
		String afterRefresh = rp.getRefreshContentLoc().getText();
		
		if(beforeRefresh.equals(afterRefresh))
		{
			System.out.println("Refresh Failed");
			
		}
		else
		{
			System.out.println("Refresh succussful");
		}
		
	}
	@Test (priority = 7)
	 
	public void explicitWt()
	{
		driver.get(prop.getProperty("explicwturl"));
		ExplictwtPage ep = new ExplictwtPage(driver);
		ep.getCheckboxLocator().click();

		ep.getRemoveBtnLocator().click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(ep.getAddButtonLocator()));
		ep.getEnableLocator().click();
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.elementToBeClickable(ep.getdisableBtnLocator()));
		
		
		
	}
	@Test (priority = 8)
	public void explicitwts()
	{
		driver.get(prop.getProperty("explicitwt2url"));
		ExplicitWts ew = new ExplicitWts(driver);
		ew.getStartLocator().click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(ew.getTextLocator()));
		driver.findElement(ew.getTextLocator()).getText();
		
		}
	

	@Test (priority = 9)
	public void downloadFile() throws IOException
	{
		driver.get(prop.getProperty("downloadUrl"));
		DownloadPage dp = new DownloadPage(driver);
		String sourceLocation = dp.getDownloadLocator().getAttribute("href");
		System.out.println("sourceLocation is" + sourceLocation);
		String wget_command = "cmd /c C:\\Windows\\System32\\wget.exe -P C:\\Users\\ivc17239adm\\wgetdown " + sourceLocation;
		try
		{
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitval = exec.waitFor();
		}
		catch(InterruptedException  ex)
		{
			System.out.println(ex.toString());
			
		}
	}
	
	@Test (priority = 10)
	public void uploadFile()
	{
		driver.get(prop.getProperty("uploadUrl"));
		UploadPage up = new UploadPage(driver);
		up.getFileUploadLocator().sendKeys("C:\\Users\\ivc17239adm\\wgetdown\\some-file.txt");
		up.getUploadButtonLoc().click();
		
	}
	// //*[@id="mceu_14-body"] //*[@id="mceu_14-body"]
	
	@Test (priority = 11)
	public void iFrametest()
	{
		driver.get(prop.getProperty("iFrmaeUrl"));
		IFramePage ip = new IFramePage(driver);
	      driver.switchTo().frame(ip.getIFrameLocator());
	      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  ip.getFrameBodyLoc().click();
	}
	@Test (priority =12)
	public void mouseHover()
	{
		driver.get(prop.getProperty("museHoverUrl"));
		MouseHoverPage mh = new MouseHoverPage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(mh.getAvatar1Loc()).perform();
		a.moveToElement(mh.getAvata2Loc()).perform();
		a.moveToElement(mh.getAvatar3Loc()).perform();
		
	}
	@Test (priority = 13)
	public void JsAlertClick()
	{
		driver.get(prop.getProperty("jsAlertUrl"));
		JsalertPage jp = new JsalertPage(driver);
		
		jp.getClickForJsAlert().click();
		Alert a = driver.switchTo().alert();
       	a.accept();
		jp.getClickForJsConfirm().click();
		a.accept();
		jp.getClickForJsPrompt().click();
		a.sendKeys("Jhi");
		a.accept();

		}
	@Test (priority = 14)
	public void newTabClick() 
	{
		driver.get(prop.getProperty("newTabUrl"));
		NewTabPage nt = new NewTabPage(driver);
        //String str =  Keys.chord(Keys.CONTROL,Keys.RETURN);
         nt.getLinkLocator().click();
		
	}
	
	
	@Test ( priority = 15 )
	
	public void contextCheck()
	{
		driver.get(prop.getProperty("contexturl"));
		ContextPage cp = new ContextPage(driver);
		Actions a = new Actions(driver);
		a.contextClick(cp.getContext()).perform();
		
				
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
}
