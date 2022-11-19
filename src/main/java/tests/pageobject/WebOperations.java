package tests.pageobject;

import annotations.NotVisible;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import annotations.Url;
import logging.Logging;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import utils.MyFluentWait;

import static driver.Driver.getDriver;
import static java.lang.String.format;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static properties.TestProperties.TEST_PROPERTIES;
import static utils.Elements.clickabilityOf;
import static utils.Elements.visibilityOf;
import static utils.LocalEnvironment.getResourcePath;
import static utils.Reflection.getHumanFriendlyName;
import static utils.Reflection.getNameForField;

public class WebOperations implements Logging {

    @Override
    public String toString() {
        return getHumanFriendlyName(getClass().getSimpleName());
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition) {
        return waitFor(condition, true);
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, boolean shouldFail) {
        return waitFor(condition, TEST_PROPERTIES.getExplicitWait(), MILLIS, shouldFail);
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, long time, TemporalUnit unit, boolean shouldFail) {
        return new MyFluentWait().waitFor(condition, time, unit, shouldFail);
    }

    public boolean isVisible() {
        return areVisible(getOwnVisibleWebElements());
    }

    protected <K extends WebElement> boolean isVisible(K element) {
        return waitFor(visibilityOf(element), false).orElse(false);
    }

    protected boolean isVisible(WebElement element, long timeOut) {
        return waitFor(visibilityOf(element), timeOut, SECONDS, false).orElse(false);
    }

    protected boolean isEnabled(WebElement element, long timeOut) {
        return waitFor(clickabilityOf(element), timeOut, SECONDS, false).orElse(false);
    }

    protected boolean isNotDisplayed(WebElement element, long timeout) {
        return waitFor(invisibilityOf(element), timeout, SECONDS, false).orElse(false);
    }

    protected String getText(WebElement element) {
        Optional<Boolean> exists = waitFor(visibilityOf(element), false);
        if (exists.isPresent() && exists.get()) {
            return element.getText();
        }
        return "COULD NOT BE FOUND";
    }

    protected String getText(WebElement element, long timeOut) {
        Optional<Boolean> exists = waitFor(visibilityOf(element), timeOut, SECONDS, false);
        if (exists.isPresent() && exists.get()) {
            return element.getText();
        }
        return "COULD NOT BE FOUND";
    }

    protected void click(WebElement element) {
        String elementName = getNameForField(this, element);
        if (!elementName.isEmpty()) {
            getLogger().info(format("Clicking on %s", elementName));
        }
        waitFor(clickabilityOf(element));
        element.click();
    }

    protected void contextClick(WebElement element) {
        String elementName = getNameForField(this, element);
        if (!elementName.isEmpty()) {
            getLogger().info(format("Context click on %s", elementName));
        }
        waitFor(clickabilityOf(element));
        Actions actions = new Actions(getDriver());
        actions.contextClick(element).perform();
    }

    protected Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }

    protected void switchToIFrame(WebElement container) {
        getDriver().switchTo().frame(container);
    }

    protected void mouseHover(WebElement element) {
        getLogger().info("Placing mouse over element");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    protected void select(WebElement element, String option) {
        getLogger().info("Selecting option [%s]", option);
        Select select = new Select(element);
        try {
            select.selectByVisibleText(option);
        } catch (NoSuchElementException e) {
            getLogger().error(format("%s: [%s] selection by visible text failed, re-attempting by value", e.getLocalizedMessage(), option));
            select.selectByValue(option);
        }
    }

    protected LogEntries getLogs() {
        return getDriver().manage().logs().get(LogType.BROWSER);
    }

    public void refreshPage() {
        getLogger().info("Refreshing page");
        getDriver().navigate().refresh();
    }

    protected void dragAndDrop(WebElement firstElement, WebElement secondElement) {
        getLogger().info("Dragging and dropping first element onto second element");
        final String java_script =
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                        + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                        + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                        + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                        + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);";
        executeJs(java_script, firstElement, secondElement);
    }

    protected void switchToTab(int tab) {
        if (tab > 1) {
            waitFor(numberOfWindowsToBe(tab));
        }

        final AtomicInteger tabs = new AtomicInteger(0);

        getDriver()
                .getWindowHandles()
                .forEach(w -> {
                    if (tabs.incrementAndGet() == tab) {
                        getDriver().switchTo().window(w);
                        return;
                    }
                });
    }

    protected void type(WebElement element, final String text, final boolean cleanFirst) {
        getLogger().info(format("Typing [%s]%s", text.replaceAll("\\p{C}", ""), cleanFirst ? " (cleaning first)" : ""));
        waitFor(visibilityOf(element));
        if (cleanFirst) {
            element.clear();
        }
        element.sendKeys(text);
    }

    protected void type(WebElement element, String text) {
        type(element, text, true);
    }

    protected void scrollToBottom() {
        getLogger().info("Scrolling to bottom of page");
        executeJs("window.scrollTo(0, document.body.scrollHeight);");
    }

    protected void uploadFile(WebElement element, String fileName) {
        getLogger().info("Uploading file " + fileName);
        element.sendKeys(getResourcePath(fileName));
    }

    public void navigateTo() {
        final Class<? extends WebOperations> pomClass = getClass();
        Url url = pomClass.getAnnotation(Url.class);
        if (ofNullable(url).isPresent()) {
            try {
                String resource = TEST_PROPERTIES.getBaseUrl() + url.value();
                URL builtUrl = new URL(resource);
                getLogger().info("Navigating to URL %s", builtUrl);
                getDriver().navigate().to(builtUrl);
            } catch (Exception e) {
                getLogger().error(format("Could not build a valid URL: %s", e.getLocalizedMessage()), e);
            }
        }
    }

    private List<WebElement> getWebElementsWithAnnotationsAndDo(Function<Class<? extends Annotation>, List<WebElement>> action) {
        List<WebElement> elements = Stream.of(FindBy.class, FindBys.class, FindAll.class)
                .map(action)
                .flatMap(List::stream)
                .collect(toList());
        return elements;
    }

    public static List<Field> getFieldsAnnotatedWith(Object object, Class<? extends Annotation> annotationClass, boolean includeParents) {
        return getFieldsFilteringBy(object, f -> f.isAnnotationPresent(annotationClass), includeParents);
    }

    public static List<Field> getFieldsFilteringBy(Object object, Predicate<Field> filter, boolean includeParents) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null!");
        }
        List<Field> fields = new ArrayList<>(asList(object.getClass().getDeclaredFields()));
        if (includeParents) {
            Class<?> cls = object.getClass().getSuperclass();
            while (cls != null) {
                fields.addAll(asList(cls.getDeclaredFields()));
                cls = cls.getSuperclass();
            }
        }
        return fields.stream().filter(filter).collect(toList());
    }

    /**
     * Collects all fields in POM annotated with FindBy but not with @NotVisible
     *
     * @return All fields annotated with FindBy but no NotVisible in Page Object
     */
    protected List<WebElement> getOwnVisibleWebElements() {
        return getWebElementsWithAnnotationsAndDo(a -> getVisibleWebElements(a, false));
    }

    private <T extends WebElement> List<T> getVisibleWebElements(Class<? extends Annotation> findBy, boolean includeParents) {
        List<Object> visibleFields = getFieldsAnnotatedWith(this, findBy, includeParents)
                .stream()
                .filter(f -> !f.isAnnotationPresent(NotVisible.class))
                .map(f -> {
                    try {
                        f.setAccessible(true);
                        return f.get(this);
                    } catch (IllegalAccessException e) {
                        getLogger().error(format("Could not retrieve %s annotated with %s!", f.getName(), findBy), e);
                        return null;
                    }
                })
                .collect(toList());

        List<T> elementFields = new ArrayList<>();
        for (Object visibleField : visibleFields) {
            if (visibleField instanceof WebElement) {
                elementFields.add((T) visibleField);
            } else {
                elementFields.addAll((Collection<T>) visibleField);
            }
        }
        return elementFields;
    }

    protected <T extends WebElement> boolean areVisible(List<T> elements) {
        String notFound = elements
                .stream()
                .filter(element -> !isVisible(element))
                .map(element -> getNameForField(this, element))
                .collect(joining(", "));

        StringBuilder message = new StringBuilder();
        message
                .append("checking visibility of elements ")
                .append((format("%s ", elements.stream().map(element -> getNameForField(this, element)).collect(joining(", ")))))
                .append(" at ")
                .append(this.getClass().getSimpleName());

        boolean areVisible = true;
        if (!notFound.isEmpty()) {
            message
                    .append("Element(s) ")
                    .append("NOT FOUND: ")
                    .append(notFound);
            areVisible = false;
        }

        getLogger().info(message.toString());
        return areVisible;
    }

    private void executeJs(String script, Object... args) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript(script, args);
        } catch (Exception ignored) {
        }
    }
}
