package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContextMenuPage extends BasePage {

    @FindBy(how = How.CSS, using = "#hot-spot")
    private WebElement contextBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage goToContextMenuPage() {
        driver.get(BASEURL + "/context_menu");
        return this;
    }

    public ContextMenuPage rightClickContextBox() {
        actions.contextClick(contextBox).perform();
        return this;
    }

}
