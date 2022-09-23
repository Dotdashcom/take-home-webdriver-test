package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage {

    @FindBy(css = "div[class=\"large-10 columns large-centered\"]>:nth-child(7)>div[class=\"large-10 columns\"]")
    protected WebElement dynamicContentSpecific;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
    public boolean isDynamicContentSame(){
        return dynamicContentSpecific.getText().contains("Asperiores at voluptatem quis aperiam quam est vel fuga\" +\n" +
                "                \" nam incidunt non consequatur enim veritatis sunt molestiae officiis omnis et laborum sed nisi reiciendis ut est\" +\n" +
                "                \" eveniet est voluptas dolorem.");
    }
}
