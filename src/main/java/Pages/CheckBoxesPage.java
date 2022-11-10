package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {

    @FindBy(xpath = "(//form[@id='checkboxes']/input)[1]")
    public WebElement checkBox1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkBox2;

    public CheckBoxesPage(){ PageFactory.initElements(Driver.getDriver(),this);}
}