package utils;

import java.util.function.Supplier;
import org.openqa.selenium.WebDriverException;

public final class Fluent {

    private Fluent() {
    }

    public static <T> T doWithTryCatch(final Supplier<T> action, final T otherWise) {
        try {
            return action.get();
        } catch (WebDriverException ex) {
            return otherWise;
        }
    }

}

