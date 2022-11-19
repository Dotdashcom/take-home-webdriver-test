package utils;

import java.util.function.Supplier;

/**
 * Supplier that allows for lazy instantiation of objects.
 */
public final class Lazy {

    private Lazy() {
    }

    public static <Z> Supplier<Z> lazily(Supplier<Z> supplier) {
        return new Supplier<Z>() {
            Z value;

            @Override
            public Z get() {
                if (value == null) {
                    value = supplier.get();
                }
                return value;
            }
        };
    }

}
