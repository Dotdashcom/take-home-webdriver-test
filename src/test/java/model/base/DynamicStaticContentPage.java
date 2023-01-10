package model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class DynamicStaticContentPage extends BasePage {

    @FindBy(css = ".row>#content>.row")
    private List<WebElement> contentRowsList;

    @FindBy(css = ".row:nth-of-type(1)>.large-2>img")
    private WebElement firstRowImage;

    @FindBy(css = ".row:nth-of-type(2)>.large-2>img")
    private WebElement secondRowImage;

    @FindBy(css = ".row:nth-of-type(3)>.large-2>img")
    private WebElement thirdRowImage;

    @FindBy(css = "#content>.row:nth-of-type(1)>.large-10")
    private WebElement firstRowText;

    @FindBy(css = "#content>.row:nth-of-type(2)>.large-10")
    private WebElement secondRowText;

    @FindBy(css = "#content>.row:nth-of-type(3)>.large-10")
    private WebElement thirdRowText;

    public DynamicStaticContentPage(WebDriver driver) {
        super(driver);
    }

    public int getContentRowsNumber() {

        return contentRowsList.size();
    }

    public String getFirstRowImageSource() {

        return firstRowImage.getAttribute("src");
    }

    public String getSecondRowImageSource() {

        return secondRowImage.getAttribute("src");
    }

    public String getThirdRowImageSource() {

        return thirdRowImage.getAttribute("src");
    }

    public String getFirstRowText() {

        return firstRowText.getText();
    }

    public String getSecondRowText() {

        return secondRowText.getText();
    }

    public String getThirdRowText() {

        return thirdRowText.getText();
    }
}