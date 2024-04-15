package datamind.advanced.trace.strategy;


import datamind.advanced.trace.strategy.code.strategy.Strategy;
import datamind.advanced.trace.template.code.SubclassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}",resultTime);
    }
}
