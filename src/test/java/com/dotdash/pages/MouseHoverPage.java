package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
    @FindBy(xpath = "//div[@class='figure'][1]")
    public WebElement hoverMouseOnFigure;

    @FindBy(xpath = "//div[@class='figcaption'][1]//*[text()='name: user1']")
    public WebElement assertDataAfterHover;

    public MouseHoverPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
