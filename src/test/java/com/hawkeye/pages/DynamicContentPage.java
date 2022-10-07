package com.hawkeye.pages;

import com.hawkeye.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {

    @FindBy(xpath = "//img[contains(@src,'/img/avatars/Original-Facebook-Geek-Profile-Avatar')][1]")
    public WebElement DynamicPicture1;

    @FindBy(xpath = "//img[contains(@src,'/img/avatars/Original-Facebook-Geek-Profile-Avatar')][2]")
    public WebElement DynamicPicture2;

    @FindBy(xpath = "//img[contains(@src,'/img/avatars/Original-Facebook-Geek-Profile-Avatar')][3]")
    public WebElement DynamicPicture3;




    @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
    public WebElement DynamicText1;


    @FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
    public WebElement DynamicText2;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
    public WebElement DynamicText3;

    public DynamicContentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
