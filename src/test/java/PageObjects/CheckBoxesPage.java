package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement BoxOne;

    @FindBy (xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement BoxTwo;
}

