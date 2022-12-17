package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownLoadFilePage {
    public DownLoadFilePage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(linkText = "some-file.txt")
    private WebElement fileClickLink;

    public void DownLoad(){
        fileClickLink.click();
    }
    public String verificationDownLoad(){
        return fileClickLink.getText();
    }
}
