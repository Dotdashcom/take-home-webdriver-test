package page_object_model.iframe_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends Base {
    public IframePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public static WebElement areaText;

    public IframePage switchIframe() {
        driver.switchTo().frame(iframe);
        return new IframePage();
    }

    public void write(String word){
        areaText.sendKeys(word);
    }
}
