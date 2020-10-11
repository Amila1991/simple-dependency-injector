package org.cordnerds.simple.dependency.injector.context;

import org.cordnerds.simple.dependency.injector.annotation.Component;
import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.model.Bean;
import org.cordnerds.simple.dependency.injector.model.factory.BeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Amila Karunathilaka
 */
public final class DIContext implements Context {

    private static Context INSATNCE;

    private final Map<Class<?>, Bean<?>> beanMap;


    private DIContext() {
        beanMap = new ConcurrentHashMap<>();
    }

    public static Context getContext() {
        if (INSATNCE == null) {
            INSATNCE = new DIContext();
        }

        return INSATNCE;
    }

    @Override
    public <T> T getBean(Class<T> type) {
        if (beanMap.containsKey(type)) {
            return type.cast(beanMap.get(type).getInstance());
        }

        Component component = type.getDeclaredAnnotation(Component.class);
        if (component == null) {
            throw new DIInstanceCreationException("{} is not bean(component annotated)", type.getTypeName());
        }
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DIInstanceCreationException("Error occurring when creating {} instance ", e, type.getTypeName());
        }
    }

    @Override
    public <T> void addBean(Bean<T> bean) {
        synchronized (beanMap) {
            beanMap.putIfAbsent(bean.getInstanceType(), bean);
        }
    }
}
