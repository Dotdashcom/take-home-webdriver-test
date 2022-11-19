package tests.pageobject;

import java.util.function.Supplier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import static java.lang.String.format;
import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.Elements.presenceOf;
import static utils.Lazy.lazily;

public class Component extends WebOperations {

    private final Supplier<WebElement> container;

    protected Component(WebElement container) {
        initComponent(getVisibleContainer(container));
        this.container = lazily(() -> container);
    }

    private void initComponent(WebElement container) {
        waitFor(presenceOf(container));
        ElementLocatorFactory decoratorFactory = new NamedElementLocatorFactory(container);
        initElements(decoratorFactory, this);
    }

    protected WebElement getContainer() {
        return container.get();
    }

    private WebElement getVisibleContainer(WebElement container) {
        if (!isVisible(container, 4)) {
            String message = format("Unable to create the component '%s' using  element container '%s'",
                    this.getClass().getSimpleName(), container.toString());
            getLogger().error(message);
            throw new IllegalStateException(message);
        }
        return container;
    }

}
