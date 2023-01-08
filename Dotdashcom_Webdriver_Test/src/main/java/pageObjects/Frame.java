package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Frame
{
    public WebDriver driver;

    public Properties pr;


    public Frame(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//iframe[@id='mce_0_ifr']")
    WebElement frame1;

    @FindBy(xpath="//body[@id='tinymce']")
    WebElement instxt;

    @FindBy(xpath="//button[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']/div")
    WebElement clickx;


    public WebElement framesw()
    {
        return frame1;
    }

    public WebElement clickclose()
    {
        return clickx;
    }

    public WebElement txtbx()
    {
        return instxt;
    }



}
