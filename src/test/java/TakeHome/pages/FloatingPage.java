package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingPage extends BasePage {

    public FloatingPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@class='scroll large-10 columns large-centered']")
    private WebElement floatingMenu;

    @FindBy(xpath = "//div[@class='example']/h3")
    private WebElement headerText;

    public boolean verifyMenu(){
        return floatingMenu.isDisplayed();
    }

    public String getFloatingMenuText() {
        return floatingMenu.getText();
    }

}
