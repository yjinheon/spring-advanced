package datamind.advanced.trace.logtrace;

import datamind.advanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus traceStatus);

    void exception(TraceStatus status, Exception e);
}
