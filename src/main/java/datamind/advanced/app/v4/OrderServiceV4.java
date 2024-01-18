package datamind.advanced.app.v4;

import datamind.advanced.app.v3.OrderRepositoryV3;
import datamind.advanced.trace.TraceId;
import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.logtrace.LogTrace;
import datamind.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;


    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<> (trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}
