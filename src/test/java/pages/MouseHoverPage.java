package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MouseHoverPage extends BasePage {

    @FindBy(xpath = "(//img)[2]")
    public WebElement img1;

    @FindBy(xpath = "(//img)[3]")
    public WebElement img2;

    @FindBy(xpath = "(//img)[4]")
    public WebElement img3;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement showText1;

    @FindBy(xpath = "(//h5)[2]")
    public WebElement showText2;

    @FindBy(xpath = "(//h5)[3]")
    public WebElement showText3;





}
