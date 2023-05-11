package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.utilities.Driver;

import java.time.Duration;

public class DynamicLoadingPage {

    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "finish")
    public WebElement textMessage;


    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;


    @FindBy(id = "loading")
    public WebElement loadingBar;


}
