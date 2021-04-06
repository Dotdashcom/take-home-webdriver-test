package TakeHome.pages;


import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends  BasePage{

    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@id='start']/button")
    private WebElement start;

    @FindBy(id = "finish")
    private WebElement message;



    public void clickStart(){
        start.click();
    }

    public String getMessage(){
        return message.getText();
    }
}
