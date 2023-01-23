package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class iframe_page extends Base_Page {
    WebDriver driver;

    public iframe_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"tinymce\"]")
    WebElement frame;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/h3")
    WebElement header;

    public void Iframe_meth() {
        driver.switchTo().frame("mce_0_ifr");
        frame.clear();
        String edit = "Hi there";
        frame.sendKeys(edit);
        check_String(frame.getText(), edit, "wrong editing");

        driver.switchTo().parentFrame();

        boolean heder_diplayed = header.isDisplayed();
        check_boolean(heder_diplayed, true, "header is not displayed");

        String actual_Header = header.getText();
        String expected_Header = "An iFrame containing the TinyMCE WYSIWYG Editor";
        check_String(actual_Header, expected_Header, "wrong header");
    }
}
