package datamind.advanced.trace.strategy;


import datamind.advanced.trace.strategy.code.strategy.Strategy;
import datamind.advanced.trace.template.code.SubclassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        strategy.call(); // delegate
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result = {}", result);
    }



}
