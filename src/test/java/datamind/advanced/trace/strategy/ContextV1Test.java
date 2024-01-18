package datamind.advanced.trace.strategy;


import datamind.advanced.trace.strategy.code.strategy.Strategy;
import datamind.advanced.trace.strategy.code.strategy.StrategyLogic1;
import datamind.advanced.trace.strategy.code.strategy.StrategyLogic2;
import datamind.advanced.trace.template.code.SubclassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

@Slf4j
public class ContextV1Test {


//    @Test
//    void strategyV0() {
//        logic1();
//        logic2();
//    }
//
//    private void logic1() {
//        long startTime = System.currentTimeMillis();
//        log.info("execute logic1");
//        long endTime = System.currentTimeMillis();
//        long result = endTime - startTime;
//        log.info("execute logic1 result={}", result);
//    }
//
//    private void logic2() {
//        long startTime = System.currentTimeMillis();
//        log.info("execute logic2");
//        long endTime = System.currentTimeMillis();
//        long result = endTime - startTime;
//        log.info("execute logic2 result={}", result);
//    }

    @Test
    void strategyV1() {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();

    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("execute logic1");
            }
        };
        log.info("strategyLogic={}",strategyLogic1.getClass());
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
    }


}
