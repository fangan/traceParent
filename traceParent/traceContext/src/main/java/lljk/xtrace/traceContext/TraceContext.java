package lljk.xtrace.traceContext;

/**
 * @Description TODO
 * @Date 2019/3/14 下午12:55
 * @Author fangan
 **/
public class TraceContext {
    private String traceId;

    private String appName;

    private String prop;

    private Long time;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}