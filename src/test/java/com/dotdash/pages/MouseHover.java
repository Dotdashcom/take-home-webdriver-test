package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;

@Url("/hovers")
public class MouseHover extends WebPage {

    @FindBy(className = "figure")
    private List<WebElement> figureImages;

    @FindBy(tagName = "h5")
    private List<WebElement> hoverTexts;

    public String getHoverText(int pos) {
        WebElement image = figureImages.get(pos);
        mouseHover(image);
        return getText(hoverTexts.get(pos));
    }

    public int getNumberOfImages() {
        return figureImages.size();
    }
}
