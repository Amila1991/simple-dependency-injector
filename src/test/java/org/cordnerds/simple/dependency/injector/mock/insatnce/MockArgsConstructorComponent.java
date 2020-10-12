package org.cordnerds.simple.dependency.injector.mock.insatnce;

import org.cordnerds.simple.dependency.injector.annotation.Component;
import org.cordnerds.simple.dependency.injector.annotation.Inject;

/**
 * @author Amila Karunathilaka
 */
@Component
public class MockArgsConstructorComponent {

    @Inject
    private MockInnerSingletonComponent innerSingletonComponent;

    @Inject
    MockInnerPrototypeComponent innerPrototypeComponent;

    int integerValue = 10;

    public MockArgsConstructorComponent(MockInnerSingletonComponent innerSingletonComponent,
                                        MockInnerPrototypeComponent innerPrototypeComponent) {
        this.innerSingletonComponent = innerSingletonComponent;
        this.innerPrototypeComponent = innerPrototypeComponent;
    }

    public MockInnerSingletonComponent getInnerSingletonComponent() {
        return innerSingletonComponent;
    }

    public MockInnerPrototypeComponent getInnerPrototypeComponent() {
        return innerPrototypeComponent;
    }
}
