package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPageModel extends PageObject {

    public static final String PAGE_URL = "/context_menu";

    @FindBy(id = "hot-spot")
    private WebElement hotSpotDivElement;

    public WebElement getHotSpotDivElement() {
        return hotSpotDivElement;
    }

    public ContextMenuPageModel(WebDriver driver) {
        super(driver);
    }

    public void hotSpotRightClick() {
        rightClick(hotSpotDivElement);
    }
}
