package datamind.advanced.app.v3;

import datamind.advanced.trace.TraceId;
import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


// 컴포넌트 스캔

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final HelloTraceV2 trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("이미 존재하는 Order입니다.");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e );
            throw  e;
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); // printStackTrace()는 예외가 발생한 메서드의 호출 스택을 출력한다.
        }
    }
}
