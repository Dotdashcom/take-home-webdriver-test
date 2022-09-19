package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkBox1;

    @FindBy (xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement checkBox2;
}
