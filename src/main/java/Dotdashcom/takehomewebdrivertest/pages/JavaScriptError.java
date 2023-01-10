package Dotdashcom.takehomewebdrivertest.pages;

	import org.testng.Assert;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

	public class JavaScriptError extends BaseClass {
		@FindBy(xpath = "//a[@href='/javascript_error']")
        WebElement link;

        @FindBy(xpath = "//body[@onload='loadError()']")
        WebElement text;
		
	

		public JavaScriptError(){
			PageFactory.initElements(driver, this);
		
		}
		public void clickJavaScriptError(){
			link.click();
	    }
		
		public void verifyError() {
            Assert.assertTrue(text.isDisplayed());
        }

}
