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

    private Integer step;

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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}
