package datamind.advanced.trace.strategy;


import datamind.advanced.trace.strategy.code.template.Callback;
import datamind.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     *  Template callback pattern
     */
    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("execute logic 1");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("execute logic 2");
            }
        });


    }


}
