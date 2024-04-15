package datamind.advanced.proxy.v1;

import datamind.advanced.proxy.v4.OrderServiceV4;
import datamind.advanced.trace.callback.TraceCallback;
import datamind.advanced.trace.callback.TraceTemplate;
import datamind.advanced.trace.logtrace.LogTrace;
import datamind.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template; // singleton


    //    private final LogTrace trace;
    //use @Autowired ->  생성자 생략가능
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new TraceCallback<>() {
            //  anonymous interanal class
            @Override
            public String call() {
                orderService.orderItem(itemId);

                return "ok";
            }
        });
    }
}
