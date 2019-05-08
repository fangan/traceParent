package lljk.xtrace.traceContext;

import lljk.xtrace.traceOption.param.AgentJvmParam;

import java.util.UUID;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:35
 * @Author fangan
 **/
public class ThreadTraceContext {

    public static TraceContext getThreadTraceContext(){

        if(TraceMap.contextMap.get(Thread.currentThread()) != null){
            TraceMap.contextMap.get(Thread.currentThread()).setStep(TraceMap.contextMap.get(Thread.currentThread()).getStep()+1);
            return TraceMap.contextMap.get(Thread.currentThread());
        }else{
            TraceContext traceContext = new TraceContext();
            traceContext.setTraceId(UUID.randomUUID().toString());
            traceContext.setAppName(AgentJvmParam.appName);
            traceContext.setTime(System.currentTimeMillis());
            traceContext.setStep(1);
            TraceMap.contextMap.put(Thread.currentThread(),traceContext);
            return traceContext;
        }
    }

}
