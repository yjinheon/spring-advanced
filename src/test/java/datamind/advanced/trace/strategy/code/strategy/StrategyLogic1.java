package datamind.advanced.trace.strategy.code.strategy;

import datamind.advanced.trace.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyLogic1 implements Strategy {

    @Override
    public void call() {
        log.info("execute logic1");
    }
}
