package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iframePage {

    public WebDriver ldriver;

    public iframePage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the box inside the frame
    @FindBy(xpath="//*[@id=\"tinymce\"]/p")
    public WebElement txtcontentbox;


    //======================ACTION METHODS========================//

    //Send some value in the box
    public void setTxtcontentbox(String content)
    {
        txtcontentbox.sendKeys(content);
    }

    //Extract the entered text from the webelement
    public String getenteredtxt()
    {
        return txtcontentbox.getText();
    }
}
