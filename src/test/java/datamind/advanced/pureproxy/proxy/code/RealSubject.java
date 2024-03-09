package datamind.advanced.pureproxy.proxy.code;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {

    @Override
    public String operation() {
        log.info("get real instance");
        sleep(1000);
        return "data";
    }


    private void sleep(int milis) {
        try {
            Thread.sleep(milis);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
