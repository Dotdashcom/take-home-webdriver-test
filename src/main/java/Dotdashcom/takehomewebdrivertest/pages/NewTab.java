package Dotdashcom.takehomewebdrivertest.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class NewTab extends BaseClass {
	@FindBy(linkText = "Multiple Windows")
    WebElement multipleWindowsButton;

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement clickHere;

    @FindBy(tagName = "h3")
    WebElement header;
	

	public NewTab(){
		PageFactory.initElements(driver, this);
	
	}

	 public void clickButtons(){
	        multipleWindowsButton.click();
	        clickHere.click();
	    }
	    public String validateNewHeader(){
	        return header.getText();







	    }

}
