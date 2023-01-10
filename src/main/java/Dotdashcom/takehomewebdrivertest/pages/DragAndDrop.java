package Dotdashcom.takehomewebdrivertest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class DragAndDrop extends BaseClass {
	
	
	
	
	@FindBy(xpath="//a[contains(text(),'Drag and Drop')]")
	WebElement draganddrop;
	
	@FindBy(id = "column-a")
    WebElement aBox;

    @FindBy(xpath = "//div[@id='column-b']")
    WebElement bBox;

	Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	

	//Initializing the Page Objects:
	public DragAndDrop(){
		PageFactory.initElements(driver, this);
	}

	public  void draganddrop(){
		j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(draganddrop)));
	        Actions actions = new Actions(driver);
	        actions.clickAndHold(bBox).moveToElement(aBox).release().build().perform();
	    }
	    public String getTextBoxA(){
	        return aBox.getText();
	    }}

