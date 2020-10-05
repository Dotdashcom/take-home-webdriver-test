package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    public WebDriver ldriver;

    public DropdownPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture Dropdown
    @FindBy(id="dropdown")
    public WebElement drpdown;

    //Click on Dropdown
    public void clkdrpdown()
    {
        drpdown.click();
    }

    //Select option 1 from dropdown
    public void selOption1()
    {
        Select selOption1 = new Select(drpdown);
        selOption1.selectByVisibleText("Option 1");
    }

    //Select option 2 from dropdown
    public void selOption2()
    {
        Select selOption2 = new Select(drpdown);
        selOption2.selectByVisibleText("Option 2");
    }

    //Get text from the dropdown button after selecting the option
    public String getOptionselected()
    {
        return drpdown.getText();
    }
}
