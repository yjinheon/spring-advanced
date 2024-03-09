package datamind.advanced.proxy.app.v1;

import datamind.advanced.trace.callback.TraceCallback;
import datamind.advanced.trace.callback.TraceTemplate;
import datamind.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);  // interface에는 item id를 넣어주여야 한다.

    @GetMapping("/v1/no-log")
    String noLog();
}
