package datamind.advanced.trace.threadlocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    private ThreadLocal<String> namesStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("save name={} -> nameStore={}", name, namesStore);
        namesStore.set(name);
        sleep(1000); // take a time to execute logic
        log.info("Check namestore={}", namesStore);

        return namesStore.get();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); // printStackTrace()는 예외가 발생한 메서드의 호출 스택을 출력한다.
        }
    }
}
