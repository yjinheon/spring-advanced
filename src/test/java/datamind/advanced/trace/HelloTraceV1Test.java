package datamind.advanced.trace;

import datamind.advanced.trace.hellotrace.HelloTraceV1;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;


public class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}
