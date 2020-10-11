package org.cordnerds.simple.dependency.injector.aspec;

import org.cordnerds.simple.dependency.injector.annotation.Component;
import org.cordnerds.simple.dependency.injector.annotation.Inject;
import org.cordnerds.simple.dependency.injector.context.Context;
import org.cordnerds.simple.dependency.injector.context.DIContext;
import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.model.factory.BeanFactory;
import org.cordnerds.simple.dependency.injector.utils.DIUtils;

import java.lang.reflect.Modifier;

/**
 * @author Amila Karunathilaka
 *
 */
public aspect DependencyInjectAspect {

    pointcut injectBean() : execution(public *..*.new(..)) && @target(org.cordnerds.simple.dependency.injector.annotation.Component);

    before() : injectBean() {
        Object instance = thisJoinPoint.getThis();
        Component component = instance.getClass().getDeclaredAnnotation(Component.class);
        if (component != null) {
            Context context = DIContext.getContext();
            context.addBean(BeanFactory.buildBean(component.scope(), instance));
        }
    }

    after() : injectBean() {
        Object instance = thisJoinPoint.getThis();
        Class<?> clzz = instance.getClass();
        Context context = DIContext.getContext();
        DIUtils.filterStaticAndFinalField(clzz).filter(field -> field.isAnnotationPresent(Inject.class)).forEach(field -> {
            Class<?> type = field.getType();
            Object bean = context.getBean(type);
            if (bean != null) {
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
                try {
                    field.set(instance, bean);
                } catch (IllegalAccessException e) {
                    throw new DIInstanceCreationException("Error occurring while injecting DI bean : {}", e, clzz.getTypeName());
                }
            }
        });
    }
}
