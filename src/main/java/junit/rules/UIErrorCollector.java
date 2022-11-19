package junit.rules;

import java.util.concurrent.Callable;
import logging.Logging;
import org.hamcrest.Matcher;
import org.junit.rules.ErrorCollector;

import static org.apache.commons.lang3.StringUtils.uncapitalize;
import static org.junit.Assert.assertThat;

public class UIErrorCollector extends ErrorCollector implements Logging {

    @Override
    public <T> void checkThat(String validation, T actual, Matcher<T> expected) {
        StringBuilder message = new StringBuilder();
        message.append("Verifying that ");
        message.append(uncapitalize(validation));
        if (actual instanceof String) {
            message
                    .append(" (expectation: ")
                    .append(expected.toString())
                    .append(")");
        }

        checkSucceeds((Callable<Object>) () -> {
            assertThat(validation, actual, expected);
            getLogger().info(message.toString());
            return actual;
        });
    }
}
