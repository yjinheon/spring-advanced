package datamind.advanced.proxy.app.v3;

import datamind.advanced.proxy.app.v1.OrderControllerV1;
import datamind.advanced.proxy.app.v2.OrderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV3 implements OrderControllerV1 {

    private final datamind.advanced.proxy.app.v2.OrderServiceV2 orderService;

    public OrderControllerV3(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("v3/request")
    public String request(String itemId) {
        log.info("request item: {}", itemId);
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("v3/no-log")
    public String noLog() {
        return "ok";
    }

}
