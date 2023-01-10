package model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseUtils;

import java.util.ArrayList;
import java.util.List;

public class FloatingMenuPage extends BasePage {

    private static final String FLOATING_MENU_ENDPOINT = "floating_menu";

    @FindBy(css = "body")
    private WebElement entirePage;

    @FindBy(css = "ul li")
    private List<WebElement> menuItemsList;

    @FindBy(css = "ul li[href*='Home')]")
    private WebElement homeMenuItem;

    @FindBy(css = "ul li[href*='News')]")
    private WebElement newsMenuItem;

    @FindBy(css = "ul li[href*='Contact')]")
    private WebElement contactMenuItem;

    @FindBy(css = "ul li[href*='About')]")
    private WebElement aboutMenuItem;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public FloatingMenuPage getFloatingMenuPage() {
        getDriver(FLOATING_MENU_ENDPOINT);

        return this;
    }

    public boolean areMenuItemsVisible () {

        return menuItemsList.stream().allMatch(WebElement::isDisplayed);
    }

    public FloatingMenuPage scrollToBottom() {
        BaseUtils.scrollToEnd(getDriver());

        return this;
    }

    public boolean isVisibleWhenScrollingInIncrements() {
        int pageHeight = entirePage.getSize().getHeight();
        int incrementOfOneFifth = Math.floorDiv(pageHeight, 5);
        List<Boolean> visibleInEachIncrement = new ArrayList<>();
        for(int i = 0; i < pageHeight; i += incrementOfOneFifth) {
            ((JavascriptExecutor) getDriver()).executeScript(String.format("window.scrollBy(0,%d)", i), "");
            visibleInEachIncrement.add(menuItemsList.stream().allMatch(WebElement::isDisplayed));
        }

        return visibleInEachIncrement.stream().allMatch(element->element);
    }
}