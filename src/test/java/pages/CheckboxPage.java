package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckboxPage {

    public CheckboxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement checkbox2;
}
