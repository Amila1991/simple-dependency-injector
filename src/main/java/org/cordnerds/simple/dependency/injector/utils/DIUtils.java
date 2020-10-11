package org.cordnerds.simple.dependency.injector.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Amila Karunathilaka
 */
public class DIUtils {
    public static  <T> Stream<Field> filterStaticAndFinalField(Class<T> clzz) {
        return Arrays
                .stream(clzz.getDeclaredFields())
                .filter(
                        field ->
                                !Modifier.isFinal(field.getModifiers()) &&
                                        !Modifier.isStatic(field.getModifiers()));
    }
}
