package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage{

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement image1;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    public WebElement image2;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    public WebElement image3;

    @FindBy(xpath = "(//div[@class='figcaption'])[1]")
    public WebElement caption1;

    @FindBy(xpath = "(//div[@class='figcaption'])[2]")
    public WebElement caption2;

    @FindBy(xpath = "(//div[@class='figcaption'])[3]")
    public WebElement caption3;

}
