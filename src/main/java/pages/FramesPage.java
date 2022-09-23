package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramesPage extends AbstractWebPage {

    @FindBy(css = "#content > div > ul > li > a")
    protected List<WebElement> iFramePageList;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage goToNestedFramesPage() {
        iFramePageList.get(0).click();
        return PageFactory.initElements(driver, NestedFramesPage.class);
    }

    public IframesPage goToIframesPage() {
        iFramePageList.get(1).click();
        return PageFactory.initElements(driver, IframesPage.class);
    }
}