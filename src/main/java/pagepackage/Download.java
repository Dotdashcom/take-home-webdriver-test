package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class Download extends BaseTest{
public Download() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@href='download/some-file.txt']")
private static WebElement downloadlink;

public void download() {
	
downloadlink.click();
}

}