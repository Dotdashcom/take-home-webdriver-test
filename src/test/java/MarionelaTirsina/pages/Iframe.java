package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iframe extends BasePage {
    @FindBy(id="mce_0_ifr")
    public WebElement iframe;
    @FindBy(xpath = "//p[text()='Your content goes here.']")
    public WebElement textBoxx;
}
