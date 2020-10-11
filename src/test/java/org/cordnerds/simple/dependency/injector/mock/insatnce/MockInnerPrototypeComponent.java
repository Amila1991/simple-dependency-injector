package org.cordnerds.simple.dependency.injector.mock.insatnce;

import org.cordnerds.simple.dependency.injector.annotation.Component;
import org.cordnerds.simple.dependency.injector.annotation.Inject;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;

/**
 * @author Amila Karunathilaka
 */
@Component(scope = Scope.PROTOTYPE)
public class MockInnerPrototypeComponent {

    @Inject
    private MockComponent component;
}
