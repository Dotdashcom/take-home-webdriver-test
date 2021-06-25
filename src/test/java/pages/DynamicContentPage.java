package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage {
    @FindBy(xpath = "(//div[@id='content']//img)[1]")
    public WebElement img1;

    @FindBy(xpath = "(//div[@id='content']//img)[2]")
    public WebElement img2;

    @FindBy(xpath = "(//div[@id='content']//img)[3]")
    public WebElement img3;

    @FindBy(xpath = "(//div[@id='content']//img/../following-sibling::div)[1]")
    public WebElement text1;

    @FindBy(xpath = "(//div[@id='content']//img/../following-sibling::div)[2]")
    public WebElement text2;

    @FindBy(xpath = "(//div[@id='content']//img/../following-sibling::div)[3]")
    public WebElement text3;

}
