package Dotdashcom.takehomewebdrivertest.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class FileUpload extends BaseClass {
	
	@FindBy(linkText = "File Upload")
    WebElement fileUploadButton;

    @FindBy(id = "file-upload")
    WebElement chooseButton;
    
    @FindBy(id = "file-submit")
    WebElement uploadButton;
    
    @FindBy(tagName = "h3")
    WebElement message;
	
Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	


	public FileUpload(){
		PageFactory.initElements(driver, this);
	
	}
	    public  void clickFileUpload(){
			
			 j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(fileUploadButton)));
			
					    	
				
	}

  
    public void clickChooseButton(String file){
        chooseButton.sendKeys(file);
    }
    public void clickUploadButton(){
        uploadButton.click();
    }
    public String getText(){
        return message.getText();
    }
}