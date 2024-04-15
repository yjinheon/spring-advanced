package datamind.advanced.proxy.v1;

import datamind.advanced.trace.callback.TraceTemplate;
import datamind.advanced.trace.logtrace.LogTrace;
import datamind.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


// 컴포넌트 스캔

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepository.save()", () -> {
                    if (itemId.equals("ex")) {
                        throw new IllegalStateException("Exeption");
                    }
                    sleep(1000);

                    return  null;
                }
        );
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); // printStackTrace()는 예외가 발생한 메서드의 호출 스택을 출력한다.
        }
    }
}
