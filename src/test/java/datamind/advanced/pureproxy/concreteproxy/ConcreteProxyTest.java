package datamind.advanced.pureproxy.concreteproxy;

import datamind.advanced.pureproxy.concreteproxy.code.ConcreteClient;
import datamind.advanced.pureproxy.concreteproxy.code.ConcreteLogic;
import datamind.advanced.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {


        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();

    }
}
