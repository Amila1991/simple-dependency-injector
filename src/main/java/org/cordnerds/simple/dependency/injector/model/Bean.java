package org.cordnerds.simple.dependency.injector.model;

import org.cordnerds.simple.dependency.injector.model.scop.Scope;

/**
 * @author Amila Karunathilaka
 */
public interface Bean<T> {

    T getInstance();

    Scope getScope();

    Class<T> getInstanceType();


}
