package org.cordnerds.simple.dependency.injector.annotation;

import org.cordnerds.simple.dependency.injector.model.scop.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Amila Karunathilaka
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    Scope scope() default Scope.SINGLETON;
}
