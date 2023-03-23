package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NotificationMessagePage {

    private SelenideElement linkClickHere = $(new ByAttribute("href", "/notification_message"));
    private SelenideElement messages = $("#flash");

    @Step("Click link Click Here")
    public void clickLinkClickHere() {
        this.linkClickHere.click();
    }

    public String getMessage() {
        return this.messages.getText().replace("×", "").trim();

    }
}
