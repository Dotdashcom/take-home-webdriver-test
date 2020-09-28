package LocalHost.Pages;


import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class DownloadPage {

    public DownloadPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@href='download/some-file.txt']")
    private WebElement textFile;

    @FindBy(xpath = "//*[@href='download/webdriverIO.png']")
    private WebElement picFile;

    @FindBy(xpath = "//*[@href='download/Logo.png']")
    private WebElement picFileLogo;



    public void DownloadText(){
        textFile.click();
        BrowserUtils.waitFor(3);
        //the path here will be different depending on Computer so you Download path is needed on each individual computer
        File file= new File("C:/Users/erago/Downloads/some-file.txt");
        Assert.assertTrue(file.exists());
    }


}
