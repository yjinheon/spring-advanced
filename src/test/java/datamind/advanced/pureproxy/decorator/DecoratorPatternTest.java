package datamind.advanced.pureproxy.decorator;

import datamind.advanced.pureproxy.decorator.code.Component;
import datamind.advanced.pureproxy.decorator.code.DecoratorPatternClient;
import datamind.advanced.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
