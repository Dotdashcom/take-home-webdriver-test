package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$;

public class WindowsPage {

    private SelenideElement linkClickHere = $(new ByAttribute("href", "/windows/new"));

    @Step("Click link Click Here ")
    public void clickLinkClickHere(){
        linkClickHere.click();
    }

}
