package utils;

import exceptions.UnfulfilledExpectationException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;

public final class Reflection {

    private static final Logger LOG = getLogger(Reflection.class);

    private Reflection() {
    }

    public static <T> T create(Class<?> type) {
        T instance = null;
        Class<T> genericType = null;
        try {
            while (type != null) {
                try {
                    ParameterizedType parameterizedType = (ParameterizedType) type.getGenericSuperclass();
                    if (parameterizedType != null) {
                        genericType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
                        break;
                    }
                } catch (ClassCastException ignored) {
                }
            }
            if (genericType == null) {
                throw new UnfulfilledExpectationException("Initial page object was not provided in class hierarchy via generic type!");
            }
            instance = genericType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return instance;
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

    public static String getNameForField(Object pom, WebElement element) {
        List<Field> pomFields = getFieldsFilteringBy(pom, f -> {
            try {
                f.setAccessible(true);
                return element != null && element == f.get(pom);
            } catch (IllegalAccessException ignore) {
            } finally {
                f.setAccessible(false);
            }
            return false;
        }, true);

        String name = pomFields
                .stream()
                .findFirst()
                .map(Field::getName)
                .orElse("");

        if (name.isEmpty()) {
            return getNameForField(element);
        }

        return getHumanFriendlyName(name);
    }

    private static String getNameForField(WebElement element) {
        String name = element.getText().isEmpty() ? element.getAttribute("value") : element.getText();
        if (name == null || name.isEmpty()) {
            String className = element.getAttribute("class");
            if (className.contains(" ")) {
                return className.split(" ")[0];
            }
            return className;
        }

        String humanFriendlyName = getHumanFriendlyName(name);
        return humanFriendlyName.length() > 20 ? humanFriendlyName.substring(0, 19) + "..." : humanFriendlyName;
    }

    public static String getHumanFriendlyName(String name) {
        if (name != null && !name.isEmpty()) {
            String mangledName = name.trim();
            if (name.contains("-")) {
                mangledName = LOWER_HYPHEN.to(LOWER_CAMEL, mangledName);
            }
            if (name.contains("_")) {
                mangledName = LOWER_UNDERSCORE.to(LOWER_CAMEL, mangledName);
            }
            return stream(mangledName.split("(?=[A-Z])")).map(StringUtils::capitalize).collect(joining(" "));
        }
        return "";
    }
}
