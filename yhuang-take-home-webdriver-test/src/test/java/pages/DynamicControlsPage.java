package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BaseDriver{
	
	public DynamicControlsPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(css="form#checkbox-example button")
	public WebElement AddRemoveBtn;
	
	@FindBy(css="form#input-example button")
	public WebElement EnableDisableBtn;
	
	@FindBy(css="form#input-example input")
	public WebElement textInput;
	
	public String getAddRemoveBtnTextAfterClick() throws InterruptedException {
		AddRemoveBtn.click();
		Thread.sleep(3000);
		return AddRemoveBtn.getText();
	}
	
	public String getEnableDisableBtnTextAfterClick(){
		EnableDisableBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return EnableDisableBtn.getText();
	}
	
	public boolean isCheckboxPresent() {
		List<WebElement> elementList = driver.findElements(By.id("checkbox"));
		if(elementList.size() == 0)
			return false;
		return true;
	}
	
	public boolean isTextInputEnabled() {
		return textInput.isEnabled();
	}
}
