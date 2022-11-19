package tests.pageobject;

import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public final class NamedElementLocatorFactory implements ElementLocatorFactory {
    private final SearchContext searchContext;

    public NamedElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    public ElementLocator createLocator(Field field) {
        return new NamedElementLocator(this.searchContext, field);
    }

}
