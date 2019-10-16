package lljk.xtrace.traceContext;

import lljk.xtrace.traceOption.param.AgentJvmParam;

import java.util.Stack;
import java.util.UUID;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:35
 * @Author fangan
 **/
public class ThreadTraceContext {

    public static TraceContext getThreadTraceContext(){

        if(TraceMap.contextMap.get() != null){
            TraceMap.contextMap.get().setStep(TraceMap.contextMap.get().getStep()+1);
            return TraceMap.contextMap.get();
        }else{
            TraceContext traceContext = new TraceContext();
            traceContext.setTraceId(UUID.randomUUID().toString());
            traceContext.setCurrentThread(Thread.currentThread());
            traceContext.setAppName(AgentJvmParam.appName);
            traceContext.setTime(System.currentTimeMillis());
            Stack spendTimeStack = new Stack();
            spendTimeStack.push(traceContext.getTime());
            traceContext.setStep(1);
            TraceMap.contextMap.set(traceContext);
            return traceContext;
        }
    }


    public static TraceContext generateThreadTraceContext(String traceId){
            TraceContext traceContext = new TraceContext();
            traceContext.setTraceId(traceId);
            traceContext.setAppName(AgentJvmParam.appName);
            traceContext.setTime(System.currentTimeMillis());
            traceContext.setStep(1);
            TraceMap.contextMap.set(traceContext);
            return traceContext;

    }

}
