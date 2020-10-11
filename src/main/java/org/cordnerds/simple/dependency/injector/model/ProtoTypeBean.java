package org.cordnerds.simple.dependency.injector.model;

import org.cordnerds.simple.dependency.injector.annotation.Inject;
import org.cordnerds.simple.dependency.injector.context.DIContext;
import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;
import org.cordnerds.simple.dependency.injector.utils.DIUtils;

import java.lang.reflect.Modifier;

/**
 * @author Amila Karunathilaka
 */
public class ProtoTypeBean<T> implements Bean<T> {

    private T instance;
    private Scope scope = Scope.PROTOTYPE;

    public ProtoTypeBean(T instance) {
        this.instance = instance;
    }

    @Override
    public T getInstance() {
        try {
            return deepCopy(this.instance);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new DIInstanceCreationException("Error occurring when executing deep copy instance type : {}",
                    e, getInstanceType().getTypeName());
        }
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public Class<T> getInstanceType() {
        return (Class<T>) this.instance.getClass();
    }

    private T deepCopy(T instance) throws IllegalAccessException, InstantiationException {
        Class<T> clzz = (Class<T>) instance.getClass();
        T newInstance = clzz.newInstance();
        DIUtils.filterStaticAndFinalField(clzz).forEach(field -> {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
                Inject inject = field.getAnnotation(Inject.class);
                try {
                    if (inject != null) {
                        Class<?> type = field.getType();
                        Object bean = DIContext.getContext().getBean(type);
                        field.set(newInstance, bean);
                    } else {
                        field.set(newInstance, field.get(instance));
                    }
                } catch (IllegalAccessException e) {
                    throw new DIInstanceCreationException("Error occurring while creating clone {}",
                            e, getInstanceType().getTypeName());
                }
            }
        });
      return newInstance;
    }

}
