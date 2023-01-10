package Dotdashcom.takehomewebdrivertest.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

	public class FloatingMenu extends BaseClass {
		@FindBy(linkText = "Floating Menu")
	    WebElement floatingMenuButton;

	    @FindBy(linkText = "Elemental Selenium")
	    WebElement scrollButton;

	    @FindBy(linkText = "Home")
	    WebElement homeButton;
		
		JavascriptExecutor j = (JavascriptExecutor) driver; 
		

		public FloatingMenu(){
			PageFactory.initElements(driver, this);
		
		}

	    public void clickFloatingMenu(){
	    	j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(floatingMenuButton)));
			
			
	    }
	    public void clickScrollButton(WebDriver driver){
	        j.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

	    }
	    public boolean isDisplayedHome(){
	        return homeButton.isDisplayed();
	    }
	}
