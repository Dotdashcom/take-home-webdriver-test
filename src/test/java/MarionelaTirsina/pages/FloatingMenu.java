package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenu extends BasePage {
    @FindBy(css = "a[href='#home']")
    public WebElement homeButton;
    @FindBy(css ="a[href='#news']" )
    public WebElement newsButton;
    @FindBy(css="a[href='#contact']")
    public WebElement contactButton;
    @FindBy(css="a[href='#about']")
    public WebElement aboutButton;
}
