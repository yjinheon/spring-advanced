package datamind.advanced.trace;

import lombok.Getter;

// 로그 시작할 때 상태 정보를 저장하는 클래스
public class TraceStatus {

    private TraceId traceId;
    private long startTimeMs; // 로그 시작 시간
    private String message; // message

    public TraceStatus(TraceId traceId, long startTime, String message) {
        this.traceId = traceId;
        this.message = message;
        this.startTimeMs = startTime;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
