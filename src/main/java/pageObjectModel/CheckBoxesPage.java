package pageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {
	private WebDriver driver;

	public CheckBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//form[@id='checkboxes']/input[1]")
	private WebElement checkBox1;

	@FindBy(how = How.XPATH, using = "//form[@id='checkboxes']/input[2]")
	private WebElement checkBox2;

	public void clickBox1() {
		checkBox1.click();
	}

	public void clickBox2() {
		checkBox2.click();
	}
	
	public boolean checkBox1() {
		return checkBox1.isSelected();
	}
	
	public boolean checkBox2() {
		return checkBox2.isSelected();
	}
}
