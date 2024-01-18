package datamind.advanced.trace.template;

import datamind.advanced.trace.TraceStatus;
import datamind.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;


    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String messege) {
        TraceStatus status = null;

        try {
            status = trace.begin(messege);
            // call logic
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {{
            trace.exception(status , e);
            throw e;
        }}
    }

    protected abstract T call();
}
