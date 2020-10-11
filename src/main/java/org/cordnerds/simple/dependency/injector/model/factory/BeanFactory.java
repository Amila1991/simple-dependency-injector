package org.cordnerds.simple.dependency.injector.model.factory;

import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.model.Bean;
import org.cordnerds.simple.dependency.injector.model.ProtoTypeBean;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;
import org.cordnerds.simple.dependency.injector.model.SingletonBean;

/**
 * @author Amila Karunathilaka
 */
public class BeanFactory {


    public static <T> Bean<T> buildBean(Scope scope, T instance) {
        switch (scope) {
            case SINGLETON:
                return new SingletonBean<T>(instance);
            case PROTOTYPE:
                return new ProtoTypeBean<T>(instance);
            default:
                throw new DIInstanceCreationException("Can't create bean. Because {} scope is invalid.", scope);
        }
    }

}
