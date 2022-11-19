package utils;

import exceptions.FrameworkTimeoutException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Optional;
import javax.annotation.Nullable;
import logging.Logging;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import static driver.Driver.getDriver;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.Optional.empty;
import static properties.TestProperties.TEST_PROPERTIES;

public class MyFluentWait implements Logging {

    private final WebDriver driver;

    public MyFluentWait() {
        this.driver = getDriver();
    }

    public <K> Optional<K> waitFor(ExpectedCondition<K> condition) {
        return waitFor(condition, true);
    }

    public <K> Optional<K> waitFor(ExpectedCondition<K> condition, boolean shouldFail) {
        return waitFor(condition, TEST_PROPERTIES.getExplicitWait(), MILLIS, shouldFail);
    }

    public <K> Optional<K> waitFor(ExpectedCondition<K> condition, long time, TemporalUnit unit, boolean shouldFail) {
        try {
            K result = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofMillis(TEST_PROPERTIES.getPollingEvery()))
                    .withTimeout(Duration.of(time, unit))
                    .withMessage(condition.toString())
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(new ExpectedCondition<K>() {
                        final long start = currentTimeMillis();

                        @Override
                        public K apply(@Nullable WebDriver driver) {
                            long remainingTimeMs = Duration.of(time, unit).toMillis() - (currentTimeMillis() - start);
                            getLogger().info(format("Remaining time for condition: %d ms. Condition is: %s", remainingTimeMs, condition.toString()));
                            return condition.apply(driver);
                        }

                    });
            return Optional.of(result);
        } catch (TimeoutException toe) {
            if (shouldFail) {
                throw new FrameworkTimeoutException(condition.toString(), time, unit);
            }
        }
        return empty();
    }

}
