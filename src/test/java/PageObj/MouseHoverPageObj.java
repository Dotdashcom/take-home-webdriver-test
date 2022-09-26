package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPageObj extends CommonMethods {

    public MouseHoverPageObj() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']//img")
    private List<WebElement> imgList;

    @FindBy(xpath = "//div[@class='example']//h5")
    private List<WebElement> info;

    public List<WebElement> imageList() {
        return imgList;
    }

    public List<WebElement> getInfo() {
        return info;
    }
}
