package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage extends BasePage{

    public MouseHoverPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement img1;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    public WebElement img2;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    public WebElement img3;

    @FindBy(xpath = "//div[@class='figcaption']/h5[.='name: user1']")
    public WebElement img1Msg;

    @FindBy(xpath = "//h5[.='name: user1']/following-sibling::a")
    public WebElement img1ViewProfile;

    @FindBy(xpath = "//div[@class='figcaption']/h5[.='name: user2']")
    public WebElement img2Msg;

    @FindBy(xpath = "//div[@class='figcaption']/h5[.='name: user2']")
    public WebElement img2ViewProfile;

    @FindBy(xpath = "//div[@class='figcaption']/h5[.='name: user3']")
    public WebElement img3Msg;

    @FindBy(xpath = "//div[@class='figcaption']/h5[.='name: user3']")
    public WebElement img3ViewProfile;



}
