package datamind.advanced.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


@Slf4j
public class ConcreteLogic {

    public String operation() {
        log.info("execute ConcreteLogic");
        return "data";
    }
}
