package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragandDropPage {

    public WebDriver ldriver;
    public DragandDropPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the box A
    @FindBy(xpath = "//*[@id=\"column-a\"]")
    public WebElement boxColumnA;

    //Capture the box B
    @FindBy(xpath = "//*[@id=\"column-b\"]")
    public WebElement boxColumnB;

    //Capture Header value of box A
    @FindBy(xpath = "//div[@id='column-a']/header")
    public WebElement headerA;

    //Capture Header value of box B
    @FindBy(xpath = "//div[@id='column-b']/header")
   public WebElement headerB;
    //Return Header value of box A
    public String getheaderA()
    {
        return headerA.getText();
    }
    //Return Header value of box B
    public String getheaderB()
    {
        return headerB.getText();
    }

}
