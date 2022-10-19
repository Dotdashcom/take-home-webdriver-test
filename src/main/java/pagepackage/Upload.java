package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class Upload extends BaseTest{
public Upload() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="file-upload")
private static WebElement choosefile;

@FindBy(id="file-submit")
private static WebElement submitfile;

@FindBy(id="uploaded-files")
private static WebElement uploadfile;

public void upload() {
	choosefile.sendKeys("C:\\Users\\shiva\\Downloads\\some-file.txt");
	action=new Actions(driver);
	action.moveToElement(submitfile).click().build().perform();
	Assert.assertEquals(uploadfile.getText().toString(), "some-file.txt");
}

}