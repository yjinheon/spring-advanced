package datamind.advanced.pureproxy.proxy.code;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject { // interface 구현

    @Override
    public String operation() {
        log.info("get real instance");
        sleep(1000); // io bound
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
