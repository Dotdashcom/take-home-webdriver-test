package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TC_14_MouseHover_Page {
    public TC_14_MouseHover_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Hovers")
    public WebElement hoverlink;

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement texts1;

    @FindBy(xpath = "(//h5)[2]")
    public WebElement texts2;

    @FindBy(xpath = "(//h5)[3]")
    public WebElement texts3;
}

