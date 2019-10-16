package lljk.xtrace.traceContext;

import java.util.Stack;

/**
 * @Description TODO
 * @Date 2019/3/14 下午12:55
 * @Author fangan
 **/
public class TraceContext {
    private String traceId;

    private Thread currentThread;

    private String appName;

    private String prop;

    private Long time;

    private Integer step;

    private Stack spendTimeStack;

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

    public Thread getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(Thread currentThread) {
        this.currentThread = currentThread;
    }

    public Stack getSpendTimeStack() {
        return spendTimeStack;
    }

    public void setSpendTimeStack(Stack spendTimeStack) {
        this.spendTimeStack = spendTimeStack;
    }
}
