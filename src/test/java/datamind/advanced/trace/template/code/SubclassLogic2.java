package datamind.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubclassLogic1 extends AbstractTemplate {

    @Override
    protected void call() {
        log.info("execute logic2");
    }
}
