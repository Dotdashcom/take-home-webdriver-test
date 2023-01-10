package Dotdashcom.takehomewebdrivertest.pages;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class FileDownload extends BaseClass {
	 @FindBy(linkText = "File Download")
	    WebElement fileDownloadButton;

	    @FindBy(linkText = "some-file.txt")
	    WebElement fileButton;
	
	
Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	


	public FileDownload(){
		PageFactory.initElements(driver, this);
	
	}
	    public  void clickonfiledownload(){
			
			 j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(fileDownloadButton)));
			
					    	
				
	}

	  
	    public void downloadButton(){
	        fileButton.click();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }

		  
	    public boolean fileexist(String filePath){
	    	File file = new File(filePath);
	    	if (file.exists()) {
                System.out.println( "the file  is present");
                return true;
            }
			return false;
	    	
	    }
	}


