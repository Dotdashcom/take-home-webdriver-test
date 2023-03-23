package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ContextMenuPage {

    private SelenideElement hotSpot = $("#hot-spot");

    @Step("Right click on Hot Sport")
    public void rightClickHotSpot (){
        this.hotSpot.contextClick();
    }

    @Step("Get Alert text")
    public String getAlertText(){
        return switchTo().alert().getText();
    }
}
