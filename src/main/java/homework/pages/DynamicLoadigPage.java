package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadigPage {

    public DynamicLoadigPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='finish']")
    public WebElement textMessage;


    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;


}
