package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class DynamicControl {
    public WebDriver driver;

    public Properties pr;


    public DynamicControl(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//form[@id='checkbox-example']/div")
    WebElement dynamcheckbx;

    @FindBy(xpath="//button[contains(text(),'Remove')]")
    WebElement rembtn;

    @FindBy(xpath="//p[@id='message']")
    WebElement gomsg;

    @FindBy(xpath="//form[@id='checkbox-example']/button")
    WebElement addbtn;

    @FindBy(xpath="//form[@id='input-example']/button")
    WebElement enabtn;

    @FindBy(xpath="//form[@id='input-example']/button")
    WebElement disbtn;

    @FindBy(xpath="//form[@id='input-example']/input")
    WebElement txtbx;





    public WebElement dynamicchkbx()
    {
        return dynamcheckbx;
    }


    public WebElement removbtn()
    {
        return rembtn;
    }

    public WebElement gonemsg()
    {
        return gomsg;
    }

    public WebElement adbtn()
    {
        return addbtn;
    }


    public WebElement enabtn()
    {
        return enabtn;
    }

    public WebElement disabtn()
    {
        return disbtn;
    }


    public WebElement textbox()
    {
        return txtbx;
    }


}