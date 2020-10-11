package org.cordnerds.simple.dependency.injector.context;

import org.cordnerds.simple.dependency.injector.model.Bean;

/**
 * @author Amila Karunathilaka
 */
public interface Context {

    <T> T getBean(Class<T> type);

    <T> void addBean(Bean<T> bean);
}
