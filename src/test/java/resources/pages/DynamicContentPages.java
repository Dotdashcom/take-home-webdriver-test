package resources.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class DynamicContentPages extends BaseClass {

    @FindBy(css="div.example #content>div:nth-of-type(3)")
    WebElement thirdImg;

    public DynamicContentPages() {
        PageFactory.initElements(driver,this);
    }

    public String userCheckPageContent() {
        String pageSrc1=driver.getPageSource();
        return pageSrc1;
    }

    public void userRefreshesPage() {
        driver.navigate().refresh();
    }

    public String userCheckPageContentAfterRefresh() {
        String pageSrc2=driver.getPageSource();
        return pageSrc2;
    }

}
