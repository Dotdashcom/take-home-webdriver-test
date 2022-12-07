package Common;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@Retention (RUNTIME)
@Target ({TYPE, METHOD, CONSTRUCTOR})
public @interface TestData {
	public String [] value() default {};
}
