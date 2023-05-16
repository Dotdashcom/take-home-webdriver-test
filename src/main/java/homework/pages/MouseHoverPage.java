package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage {

    public MouseHoverPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    Actions actions = new Actions(Driver.getDriver());

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement image;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[1]")
    public WebElement textBelow;



}
