package utils;

import java.util.List;
import javax.annotation.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static java.lang.String.format;
import static utils.Fluent.doWithTryCatch;

public class Elements {

    private Elements() {
    }

    public static <T extends WebElement> boolean isVisible(final T e) {
        return doWithTryCatch(e::isDisplayed, false);
    }

    public static <T extends WebElement> boolean isEnabled(final T e) {
        return doWithTryCatch(e::isEnabled, false);
    }

    public static <T extends WebElement> ExpectedCondition<Boolean> visibilityOf(final T e) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return isVisible(e);
            }

            @Override
            public String toString() {
                return format("visibility of element [%s]", e.toString());
            }
        };
    }

    public static <T extends WebElement> ExpectedCondition<Boolean> presenceOf(final T element) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                return doWithTryCatch(() -> !element.getTagName().isEmpty(), false);
            }

            @Override
            public String toString() {
                return format("presence in DOM of element: %s", element);
            }
        };
    }

    public static <T extends WebElement> ExpectedCondition<Boolean> clickabilityOf(final T e) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return isEnabled(e) && isVisible(e);
            }

            @Override
            public String toString() {
                return format("clickable state of element [%s]", e.toString());
            }
        };
    }

}
