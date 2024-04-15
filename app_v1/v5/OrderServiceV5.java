package datamind.advanced.proxy.v1;

import datamind.advanced.proxy.v4.OrderRepositoryV4;
import datamind.advanced.trace.callback.TraceCallback;
import datamind.advanced.trace.callback.TraceTemplate;
import datamind.advanced.trace.logtrace.LogTrace;
import datamind.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }

}
