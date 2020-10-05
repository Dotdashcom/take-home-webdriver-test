package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicContentPage {
    public WebDriver ldriver;

    public DynamicContentPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the text
    @FindBy(id="content")
    WebElement txtcontent;


    //Get the text of all the rows
    public String gettxtcontent()
    {
        return txtcontent.getText();
    }


}
