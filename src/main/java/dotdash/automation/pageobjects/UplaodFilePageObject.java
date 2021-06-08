package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UplaodFilePageObject extends BasePageObject {
    @FindBy(id = "file-upload")
    private WebElement choose;

    @FindBy(id = "file-submit")
    private WebElement submit;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFile;

    public UplaodFilePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UplaodFilePageObject chooseFile() {
        choose.click();
        choose.sendKeys(System.getProperty("user.dir") + "/src/test/resources/sample-upload.txt");
        return this;
    }

    public UplaodFilePageObject upload() {
        submit.click();
        return this;
    }

    public String getSuccessMessage() {
        return uploadedFile.getText();
    }
}
