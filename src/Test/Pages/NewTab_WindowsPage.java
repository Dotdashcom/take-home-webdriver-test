package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTab_WindowsPage {
    public NewTab_WindowsPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }
    @FindBy(linkText = "Click Here")
    private WebElement link;

    @FindBy(xpath = "//h3[.='New Window']")
    private WebElement newTab;

    public void ClickLink(){
        link.click();
    }
    public String NewTabMessage(){
        return newTab.getText();
    }


}
