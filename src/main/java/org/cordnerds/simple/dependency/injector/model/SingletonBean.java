package org.cordnerds.simple.dependency.injector.model;

import org.cordnerds.simple.dependency.injector.model.scop.Scope;

/**
 * @author Amila Karunathilaka
 * @Represent dependency injection bean which is has singleton scope
 */
public class SingletonBean<T> implements Bean<T> {

    private T instance;
    private Scope scope = Scope.SINGLETON;

    public SingletonBean(T instance) {
        this.instance = instance;
    }

    @Override
    public T getInstance() {
        return this.instance;
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public Class<T> getInstanceType() {
        return (Class<T>) this.instance.getClass();
    }

}
