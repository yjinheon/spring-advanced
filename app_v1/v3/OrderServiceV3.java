package datamind.advanced.proxy.v3;

import datamind.advanced.proxy.v1.OrderRepositoryV2;
import datamind.advanced.trace.TraceId;
import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.hellotrace.HelloTraceV2;
import datamind.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;


    public void orderItem(TraceId traceId,String itemId) {
      TraceStatus status = null;

        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }


}
