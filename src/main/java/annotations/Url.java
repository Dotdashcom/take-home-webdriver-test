package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE})
public @interface Url {

    public String value() default EMPTY;
}