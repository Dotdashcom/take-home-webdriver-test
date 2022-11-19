package tests.pageobject;

import java.lang.reflect.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;

public class NamedElementLocator extends DefaultElementLocator {

    private final By by;

    public NamedElementLocator(SearchContext searchContext, Field field) {
        this(searchContext, new Annotations(field));
    }

    public NamedElementLocator(SearchContext searchContext, AbstractAnnotations annotations) {
        super(searchContext, annotations);
        this.by = annotations.buildBy();
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
