package datamind.advanced.trace.strategy;


import datamind.advanced.trace.strategy.code.strategy.Strategy;
import datamind.advanced.trace.strategy.code.strategy.StrategyLogic1;
import datamind.advanced.trace.strategy.code.strategy.StrategyLogic2;
import datamind.advanced.trace.template.code.SubclassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

@Slf4j
public class ContextV2Test {


    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2(); // - 실행시점에 유연하게 Code Snippet을 전달함
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());

    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() { //

            @Override
            public void call() {
                log.info("execute logic1");
            }
        });

        contextV2.execute(new Strategy() {

            @Override
            public void call() {
                log.info("execute logic2");
            }
        });


    }

    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(()-> log.info("execute logic1")); // 컨텍스트를 바로 인자로 전달

    }




}
