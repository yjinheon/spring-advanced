package datamind.advanced.proxy.v2;

import datamind.advanced.proxy.v1.OrderRepositoryV2;
import datamind.advanced.trace.TraceId;
import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;


    public void orderItem(TraceId traceId,String itemId) {
      TraceStatus status = null;

        try {
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }


}
