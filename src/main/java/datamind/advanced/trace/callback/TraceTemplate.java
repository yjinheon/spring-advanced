package datamind.advanced.trace.callback;

import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String messege, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(messege);
            // call logic
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            {
                trace.exception(status, e);
                throw e;
            }
        }
    }
}


