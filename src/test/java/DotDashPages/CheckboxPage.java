package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {
    public WebDriver ldriver;

    public CheckboxPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the checkbox of checkbox1
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement chkbox1;

    //Capture the checkbox of checkbox2
    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement chkbox2;



    //Click on first checkbox
    public void clkchkbox1()
    {
        chkbox1.click();
    }

    //Click on first checkbox
    public void clkchkbox2()
    {
        chkbox2.click();
    }

}
