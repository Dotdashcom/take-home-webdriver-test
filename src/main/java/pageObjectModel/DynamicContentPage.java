package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
	private WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "click here")
	private WebElement dynamicContentLink;
	
	@FindBy(how = How.XPATH,using ="(//div[@class='large-10 columns'])[1]")
	private WebElement columOneTextField;
	
	@FindBy(how = How.XPATH,using ="(//div[@class='large-10 columns'])[2]")
	private WebElement columTwoTextField;
	
	@FindBy(how = How.XPATH,using ="(//div[@class='large-10 columns'])[3]")
	private WebElement columThreeTextField;
	
	public void refreshPage() {
		dynamicContentLink.click();		
	}
	
	public String getFirstContent() {
		return columOneTextField.getText();
	}
	
	public String getSecondContent() {
		return columTwoTextField.getText();
	}
	
	public String getThirdContent() {
		return columThreeTextField.getText();
	}

}
