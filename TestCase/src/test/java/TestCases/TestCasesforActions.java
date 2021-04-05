package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.robot.Key;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.*;
import pageObjects.LoginPage;

import javax.swing.plaf.basic.BasicSeparatorUI;
 // WebDriverWait mywait = new WebDriverWait(driver, 10);

public class TestCasesforActions extends BaseClass
{
   // WebDriverWait mywait = new WebDriverWait(driver, 10);
    @Test(priority=1) //Test Case for Login Success
    public void LoginTestPass()
    {
    	//Launching login page URL
        driver.get(BaseUrl+"login");
        //Creating Object of POM for Login Page
    	LoginPage lp=new LoginPage(driver);
    	//Calling Methods for Username and Password from POM LoginPage
        lp.SetUserName(username);
        lp.SetPassword(password);
        //Clicking Login Method
        lp.ClickLogin();
        //Checking Assertions to make sure User has logged in
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
    
    @Test(priority=2) //Test Case for Login Failure
    public void LoginTestFail()
    {
        //Launching login page URL
    	driver.get(BaseUrl+"login");
        //Creating Object of POM for Login Page
    	LoginPage lp=new LoginPage(driver);
        //Calling Methods for Username and Password from POM LoginPage for Wrong Credentials
    	lp.SetUserName(wrngUname);
    	lp.SetPassword(wrngPwd);
        //Clicking Login Method
    	lp.ClickLogin();
    	//assertions to check Login failed for incorrect user and password.
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

    @Test(priority=3) //Test Case for Selecting and UnSelecting CheckBoxes
    public void CheckBox()
    {
         //Launching URL for CheckBoxes
        driver.get(BaseUrl+"checkboxes");
        //Inspecting WebElement for first CheckBox
        WebElement chkbox1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        //Clicking on CheckBox1
        chkbox1.click();
        //storing checkBox result into A boolean variable
        boolean result= chkbox1.isSelected();
        //printing Checked CheckBox value
            System.out.println("CheckBox1 Expected result is True: "+chkbox1.isSelected());
        //Assrtions for check Box Checking and UnChecking
          Assert.assertEquals(result,true,"Assertion Msg Check Box Selected");
             //Unchecking CheckBox1
              chkbox1.click();
        //storing uncheckBox result into A boolean variable
             boolean result2=chkbox1.isSelected();
            //Printing Unchecked CheckBox Value
           System.out.println("CheckBox1 Expected result is false : "+chkbox1.isSelected());
        Assert.assertEquals(result2,false,"Assertion Msg CheckBox Unselected");
      //Inspecting WebElement for Second CheckBox

        WebElement chkbox2=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
      //Clicking on CheckBox2
        chkbox2.click();
     //storing checkBox result into A boolean variable
        boolean chkres=chkbox2.isSelected();
        System.out.println("CheckBox2 Expected result is false: "+chkbox2.isSelected());
        //Assertions for check Box Checking and UnChecking
        Assert.assertEquals(chkres,false);
        //Clicking on CheckBox2
        chkbox2.click();
         //Storing boolean value for checkBox
        boolean chkres2=chkbox2.isSelected();
        System.out.println("CheckBox2 Expected result is true : "+chkbox2.isSelected());
         //Assertion for after checking the check Box
        Assert.assertEquals(chkres2,true);
    }

    @Test(priority=4) //Test Case for Context menu
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

    @Test(priority=5) //Test Case for Drag and Drop
    public void DragAndDrop()
    {
    	//Launching Drag and Drop URL
        driver.get(BaseUrl+"drag_and_drop");
        //Inspecting dragging WebElement
    	WebElement Source=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
    	String DragbleTxt=Source.getText();
    	//Getting text from Source
    	System.out.println(DragbleTxt);
    	//inspecting droppable webElement
    	WebElement Target=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
    	//Getting text from Target
    	String DropblTxt=Target.getText();
    	System.out.println(DropblTxt);
    	// Using Actions Class for Mouse Drag And Drop Action
    	Actions act=new Actions(driver);

    	//dragging source Element A to Target Element B
    	act.dragAndDrop(Source, Target).build().perform();
    	//Assertion for After Drag and Drop
        Assert.assertEquals(DragbleTxt,"A");
        //dragging Target Eleemnt B to Source Element A
        act.dragAndDrop(Target,Source).build().perform();
        //Assertion for Target to source
        Assert.assertEquals(DropblTxt,"B");
    }

    @Test(priority=6) //Test Case for DropDown
    public void DropDown() throws InterruptedException
    {
        //Launching DropDown Url
        driver.get(BaseUrl+"dropdown");
        String[] drpmenu={"Please select an option","Option 1","Option 2"};
        //Inspecting drop down using Select Class
       // public String get_SelOptions(WebElement element)
        {
            Select drpdwn = new Select(driver.findElement(By.id("dropdown")));
            //Find How many options in drop down menu
            System.out.println("No.of drop down options in dropdown menu :" + drpdwn.getOptions().size());
            //Fetching DropDown Options from drop down menu
            List<WebElement> options = drpdwn.getOptions();
            for (WebElement e : options) {
                System.out.println(e.getText());

            }
        }

    }

    @Test(priority=7) // Test Case for Dynamic Content Refresh
    public void DynamicContentRefresh() throws InterruptedException
    {
        //Launching Url for Dynamic Refresh
    	driver.get(BaseUrl+"dynamic_content");
    	//navigating driver to refresh first time
    	driver.navigate().refresh();
        //Putting some wait time to see driver refresh clearly for first refresh
    	Thread.sleep(3000);
    	//Checking PageSource Text After refresh the Page first time
    	if(driver.getPageSource().contains("This example demonstrates the ever-evolving nature of content by loading new text and images on each page refresh."))
        {
             //Checking Assertion for Page Refresh for first time
            Assert.assertTrue(true);
            //First time PageRefresh Confirmation Msg
            System.out.println("Page Refreshed one time");
        }
    	else
        {
            Assert.assertTrue(false);
        }
    	//navigating driver to refresh the page second Time
    	driver.navigate().refresh();
    	//Putting some wait time to see driver refresh clearly for second refresh
        Thread.sleep(3000);
        //Checking PageSource Text After refresh the Page second time
        if(driver.getPageSource().contains("This example demonstrates the ever-evolving nature of content by loading new text and images on each page refresh."))
        {
            //Checking Assertion for Page Refresh for second time
            Assert.assertTrue(true);
            //Second time Page refresh confirmation msg
            System.out.println("Page Refreshed second time");
        }
        else
        {
            Assert.assertTrue(false);
        }

    }

    @Test(priority=10) //Test Case for File_Download
    public void File_Download()
    {
    	//Launching Url for File Download
        driver.get(BaseUrl+"download");
        //inspecting Text file Element on the page with name "some-file.txt"

    	WebElement fileTxt1=driver.findElement(By.linkText("some-file.txt"));
    	//clicking on file to download
            fileTxt1.click();
            //Capturing the file Name and store into a string variable
            String Filetxt=fileTxt1.getText();
            System.out.println("First File Name :"+Filetxt);
            //Checking Asserrtion for Succeful File Download
            Assert.assertEquals(Filetxt,"some-file.txt");
            System.out.println("First File Downloaded Successfully");
       //inspecting Text file Element on the page with name "some-file (5).txt"

    	  WebElement filetxt2=driver.findElement(By.linkText("some-file (5).txt"));
    	  //clicking on file 2 to download
    	  filetxt2.click();
    	  //Capturing the file Name2 and store into a string variable
    	  String FileTxt2=filetxt2.getText();
    	  System.out.println("Second File Name :"+FileTxt2);
        //Checking Asserrtion for Succeful File Download
        Assert.assertEquals(FileTxt2,"some-file (5).txt");
        System.out.println("Second File Downloaded Successfully");
    }
    		
    @Test(priority=11)
    public void FileUpload()
    {
    	driver.get(BaseUrl+"upload");
    	WebElement Upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
    	Upload.click();

    	String txtfilepath="C:\\Users\\shahi\\Downloads\\some-file.txt";
    	Upload.sendKeys(txtfilepath);
    }
    
    @Test(priority=10)
    public void FloatingMenu()
    {
    	driver.get(BaseUrl+"floating_menu");
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,4000)","");
    }
    
    @Test(priority=11)
    public void IFrame() throws InterruptedException
    {
    	driver.get(BaseUrl+"iframe");//*[@id="content"]/div/div
    	WebElement iFrame=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div"));
        //*[@id="content"]/div/div
    	driver.switchTo().frame(iFrame);
    	Thread.sleep(3000);
    	//driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div/button/div/svg")).click();
    	//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[1]/span")).click();
    	//driver.findElement(By.xpath("//span[contains(text(),'Paragraph')]")).click();
    	driver.findElement(By.id("tinymce")).sendKeys("Hello");
    }

    @Test(priority=8)
    public void Dynamic_Controls() throws InterruptedException
    {
        //Launching Dynamic Controls URL
        driver.get(BaseUrl + "dynamic_controls");
        //Inspecting  WebElement CheckBox for Clicking
        driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input ")).click();
        //Using WebDriver Wait for Explicit Wait
        WebDriverWait mywait = new WebDriverWait(driver, 10);
        //Inspecting WebElement Remove Button to click on it
        WebElement RemvBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        RemvBtn.click();
        Thread.sleep(3000);
        //Inspecting text after click on Remove Button
        WebElement TxtForChkBoxRemv=driver.findElement(By.xpath("//*[@id=\"message\"]"));
           System.out.println("Text for Check Box after click on Remove Button :"+TxtForChkBoxRemv.getText());
          //Assertion Checking for check box is Gone!
           if(TxtForChkBoxRemv.equals("It's gone!"))
           {
               System.out.println("Assertion test passed for CheckBox Gone");
                Assert.assertTrue(true);

           }

        //Inspecting AddBtn and Using Explicit wait condition on AddBtn
        WebElement AddBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        AddBtn.click();
        Thread.sleep(3000);
        //Inspecting text after click on Add Button
        WebElement TxtForAddBtn= driver.findElement(By.xpath("//*[@id='message']"));
        System.out.println("Text for Check Box After click on Add  Button: "+TxtForAddBtn.getText());
        //Assertion checking for CheckBox is Back!
        if(TxtForAddBtn.equals("It's back!"))
        {
            System.out.println("Assertion test passed for CheckBox present");
            Assert.assertTrue(true);

        }

        //Inspecting Enable Button to click Using Explicit Wait condition
        WebElement EnblBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
        EnblBtn.click();
        Thread.sleep(3000);
        WebElement TxtForEnablBtn=driver.findElement(By.xpath("//*[@id='message']"));
        System.out.println("Text after clicking on Enable Button: "+TxtForEnablBtn.getText());


        //Assertion checking for Enable Button
        if(TxtForEnablBtn.equals("It's enabled!"))
        {
            System.out.println("Assertion check passes for Enable Button");
            Assert.assertTrue(true);
        }
        //inspecting WebElement TextBOx to send Message
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).sendKeys("Hello");
       // Thread.sleep(3000);
        //Inspecting Disable Button to click by applying  Explicit Wait condition
        WebElement DisblBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
        DisblBtn.click();
        Thread.sleep(3000);
        WebElement TxtforDsblBtn=driver.findElement(By.xpath("//*[@id=\"message\"]"));
        System.out.println("Text after clicking on Disable Button: "+TxtforDsblBtn.getText());
      //Assertion checking for Disable Button
        if(TxtforDsblBtn.equals("It's disabled!"))
        {
            System.out.println("Assertion check passes for Disable Button");
            Assert.assertTrue(true);
        }
    }

    @Test(priority=9) //Test case for Dynamic Loading
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
    @Test(priority=12)
    public void MouseHover()
    {
    	driver.get(BaseUrl+"hovers");
    	WebElement image1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
    	WebElement image2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
    	WebElement image3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
    	Actions act=new Actions(driver);
    	act.moveToElement(image1).moveToElement(image2).moveToElement(image3).click().build().perform();
    }
    
    @Test(priority=13)
    public void JSAlerts()
    {
    	driver.get(BaseUrl+"javascript_alerts");
    	WebElement JSAlert=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
    	JSAlert.click();
    	driver.switchTo().alert().accept();
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
    	driver.switchTo().alert().dismiss();
    }
    
    @Test(priority=14)
    public void OpenNewWindow() throws InterruptedException
    {
    	driver.get(BaseUrl+"windows");
    	driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> handlevalues=driver.getWindowHandles();
        for(String h:handlevalues)
        {
            System.out.println(h);
            String title=driver.switchTo().window(h).getTitle();
            System.out.println(title);

        }
        /*driver.navigate().to(BaseUrl+"windows");
    	Thread.sleep(3000);
         driver.close();*/
    }
    
    @Test(priority=15)
    public void NotificationMsg()
    {
    	driver.get(BaseUrl+"notification_message_rendered");
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
    	System.out.println(driver.findElement(By.id("flash")).getText());
    }
}
