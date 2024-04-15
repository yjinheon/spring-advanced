package datamind.advanced.trace.threadlocal;

import datamind.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FileldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void logic() {
        log.info("main start");

//        Runnable userC = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }

        Runnable userA = () -> fieldService.logic("userA"); // userA is a logic name
        Runnable userB = () -> fieldService.logic("userB"); // userA is a logic name

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");
        Thread threadB = new Thread(userB);
        threadB.setName("threadB");

        threadA.start();
        //sleep(2000); // start B after 2 seconds . solve concurrency problem
        sleep(100); // to incur concurrency problem
        threadB.start();

        sleep(2000); // wait for main thread to finish
        log.info("main end");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); // printStackTrace()는 예외가 발생한 메서드의 호출 스택을 출력한다.
        }
    }
}
